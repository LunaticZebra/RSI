package com.example.rsi_projekt;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
public class FishController {

    FishRepository dataRepo = new FishRepositoryImpl();
    ProducentExchange producentExchange = new ProducentExchange();
    String STANDARD_LOG = "standard";
    String STATE_LOG = "state";
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/fish/{id}")
    public EntityModel<Fish> getFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called GET");
            Fish fish = dataRepo.getFish(id);
            EntityModel<Fish> fishModel = EntityModel.of(fish,
                    linkTo(methodOn(FishController.class).getFish(id)).withSelfRel(),
                    linkTo(methodOn(FishController.class).deleteFish(id)).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
            if(fish.getFishStatus() == FishStatus.FROZEN) fishModel.add(linkTo(methodOn(FishController.class).orderFish(id)).withRel("order fish"));
            if(fish.getFishStatus() == FishStatus.ORDERED) fishModel.add(linkTo(methodOn(FishController.class).cookFish(id)).withRel("cook fish"));
            if(fish.getFishStatus() == FishStatus.COOKED) fishModel.add(linkTo(methodOn(FishController.class).payForFish(id)).withRel("pay for fish"));
            producentExchange.publishMessage(STANDARD_LOG, "GET RESOURCE WITH ID " + id);
            return fishModel;

        } catch (FishNotFoundEx e) {
            System.out.println("...GET Exception");
            throw e;
        } catch (ConflictEx e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/fish")
    public CollectionModel<EntityModel<Fish>> getAllFish() {
        System.out.println("...called GET all Fish");
        List<EntityModel<Fish>> allFish = dataRepo.getAllFish().stream().map( fish ->
        {
            try {
                EntityModel<Fish> fishModel = EntityModel.of(fish,
                        linkTo(methodOn(FishController.class).getFish(fish.getId())).withSelfRel(),
                        linkTo(methodOn(FishController.class).deleteFish(fish.getId())).withRel("delete"),
                        linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
                if(fish.getFishStatus() == FishStatus.FROZEN) fishModel.add(linkTo(methodOn(FishController.class).orderFish(fish.getId())).withRel("order fish"));
                if(fish.getFishStatus() == FishStatus.ORDERED) fishModel.add(linkTo(methodOn(FishController.class).cookFish(fish.getId())).withRel("cook fish"));
                if(fish.getFishStatus() == FishStatus.COOKED) fishModel.add(linkTo(methodOn(FishController.class).payForFish(fish.getId())).withRel("pay for fish"));
                producentExchange.publishMessage(STANDARD_LOG, "GET ALL CALLED");
                return fishModel;
            } catch (FishNotFoundEx e) {
                throw new RuntimeException(e);
            } catch (ConflictEx e) {
                throw new RuntimeException(e);
            }
        }
        ).toList();

        return CollectionModel.of(allFish, linkTo(methodOn(FishController.class).getAllFish()).withSelfRel());
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)

    @DeleteMapping("/fish/{id}")
    public ResponseEntity<String> deleteFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called DELETE");
            dataRepo.deleteFish(id);
            producentExchange.publishMessage(STANDARD_LOG, "DELETE CALLED ON RESOURCE WITH ID " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (FishNotFoundEx e) {
            System.out.print("...DELETE exception");
            throw e;
        }
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/fish")
    public EntityModel<Fish> addFish(@RequestBody Fish fishResource) throws FishExistsEx {
        try {
            System.out.print("...called POST");
            if(Objects.equals(fishResource.getName(), "") || fishResource.getWeight() == 0.0f) throw new UnfilledFieldsEx();
            producentExchange.publishMessage(STANDARD_LOG, "POST CALLED, CREATED RESORUCE WITH ID " + fishResource.getId());
            return EntityModel.of(dataRepo.addFish(fishResource.getId(), fishResource.getName(),
                            fishResource.getWeight(), fishResource.isSaltwater()),
                    linkTo(methodOn(FishController.class).getFish(fishResource.getId())).withSelfRel(),
                    linkTo(methodOn(FishController.class).deleteFish(fishResource.getId())).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
        } catch (FishExistsEx e) {
            System.out.println("...POST Exception");
            throw e;
        }
        catch (FishNotFoundEx e) {
            System.out.println("...POST Exception");
            System.out.println("Fish not found exception?");
            throw new RuntimeException();
        } catch (UnfilledFieldsEx e) {
            System.out.println("POST Exception");
            System.out.println("Field unfulfilled exception");
            throw new RuntimeException(e);
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/fish/{id}")
    public EntityModel<Fish> updateFish(@PathVariable int id, @RequestBody Fish fishResource) throws FishNotFoundEx {
        try {
            System.out.print("...called PUT");
            producentExchange.publishMessage(STANDARD_LOG, "UPDATE CALLED ON RESOURCE WITH ID " + id);
            return EntityModel.of(dataRepo.updateFish(id, fishResource.getName(),
                    fishResource.getWeight(), fishResource.isSaltwater()),
                    linkTo(methodOn(FishController.class).getFish(fishResource.getId())).withSelfRel(),
                    linkTo(methodOn(FishController.class).deleteFish(fishResource.getId())).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
        } catch (FishNotFoundEx e) {
            System.out.println("...PUT Exception");
            throw e;
        }
    }

    @PatchMapping("/fish/{id}/order")
    public EntityModel<Fish> orderFish(@PathVariable int id) throws ConflictEx{
        try{
            System.out.print("Called orderFish with id of" + id);
            Fish fish = dataRepo.getFish(id);
            if(fish.getFishStatus() != FishStatus.FROZEN) throw new ConflictEx();
            fish.setFishStatus(FishStatus.ORDERED);
            producentExchange.publishMessage(STATE_LOG, "CHANGED RESOURCE WITH " + id + " STATE TO ORDERED");
            return EntityModel.of(fish, linkTo(methodOn(FishController.class).cookFish(id)).withRel("cook"),
                    linkTo(methodOn(FishController.class).deleteFish(id)).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));

        } catch (FishNotFoundEx e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/fish/{id}/cook")
    public EntityModel<Fish> cookFish(@PathVariable int id) throws ConflictEx{
        try{
            System.out.print("Called orderFish with id of" + id);
            Fish fish = dataRepo.getFish(id);
            if(fish.getFishStatus() != FishStatus.ORDERED) throw new ConflictEx();
            fish.setFishStatus(FishStatus.COOKED);
            producentExchange.publishMessage(STATE_LOG, "CHANGED RESOURCE WITH " + id + " STATE TO COOKED");
            return EntityModel.of(fish, linkTo(methodOn(FishController.class).payForFish(id)).withRel("pay"),
                    linkTo(methodOn(FishController.class).deleteFish(id)).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));

        } catch (FishNotFoundEx e) {
            throw new RuntimeException(e);
        }
    }

    @PatchMapping("/fish/{id}/pay")
    public EntityModel<Fish> payForFish(@PathVariable int id) throws ConflictEx{
        try{
            System.out.print("Called orderFish with id of" + id);
            Fish fish = dataRepo.getFish(id);
            if(fish.getFishStatus() != FishStatus.COOKED) throw new ConflictEx();
            fish.setFishStatus(FishStatus.PAID);
            producentExchange.publishMessage(STATE_LOG, "CHANGED RESOURCE WITH " + id + " STATE TO PAID");
            return EntityModel.of(fish, linkTo(methodOn(FishController.class).deleteFish(id)).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));

        } catch (FishNotFoundEx e) {
            throw new RuntimeException(e);
        }
    }

}