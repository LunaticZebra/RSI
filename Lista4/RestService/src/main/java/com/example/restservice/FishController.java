package com.example.restservice;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class FishController {

    FishRepository dataRepo = new FishRepositoryImpl();

    @GetMapping("/fish/{id}")
    public EntityModel<Fish> getFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called GET");
            return EntityModel.of(dataRepo.getFish(id),
                    linkTo(methodOn(FishController.class).getFish(id)).withSelfRel(),
                    linkTo(methodOn(FishController.class).deleteFish(id)).withRel("delete"),
                    linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
        } catch (FishNotFoundEx e) {
            System.out.println("...GET Exception");
            throw e;
        }
    }

    @GetMapping("/fish")
    public CollectionModel<EntityModel<Fish>> getAllFish() {
        System.out.println("...called GET all Fish");
        List<EntityModel<Fish>> allFish = dataRepo.getAllFish().stream().map( fish ->
        {
            try {
                return EntityModel.of(fish,
                        linkTo(methodOn(FishController.class).getFish(fish.getId())).withSelfRel(),
                        linkTo(methodOn(FishController.class).deleteFish(fish.getId())).withRel("delete"),
                        linkTo(methodOn(FishController.class).getAllFish()).withRel("list all"));
            } catch (FishNotFoundEx e) {
                throw new RuntimeException(e);
            }
        }
        ).toList();

        return CollectionModel.of(allFish, linkTo(methodOn(FishController.class).getAllFish()).withSelfRel());
    }

    @DeleteMapping("/fish/{id}")
    public ResponseEntity<String> deleteFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called DELETE");
            dataRepo.deleteFish(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (FishNotFoundEx e) {
            System.out.print("...DELETE exception");
            throw e;
        }
    }

    @PostMapping("/fish")
    public EntityModel<Fish> addFish(@RequestBody Fish fishResource) throws FishExistsEx {
        try {
            System.out.print("...called POST");
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
        }
    }

    @PutMapping("/fish/{id}")
    public EntityModel<Fish> updateFish(@PathVariable int id, @RequestBody Fish fishResource) throws FishNotFoundEx {
        try {
            System.out.print("...called PUT");
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
}