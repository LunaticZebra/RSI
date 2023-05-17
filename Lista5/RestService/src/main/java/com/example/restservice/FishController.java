package com.example.restservice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class FishController {

    FishRepository dataRepo = new FishRepositoryImpl();

    @GetMapping("/fish/{id}")
    public Fish getFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called GET");
            return dataRepo.getFish(id);
        } catch (FishNotFoundEx e) {
            System.out.println("...GET Exception");
            throw e;
        }
    }

    @GetMapping("/fish")
    public List<Fish> getAllFish() {
        System.out.println("...called GET all Fish");
        return dataRepo.getAllFish();
    }

    @DeleteMapping("/fish/{id}")
    public HttpStatus deleteFish(@PathVariable int id) throws FishNotFoundEx {
        try {
            System.out.println("...called DELETE");
            dataRepo.deleteFish(id);
            return HttpStatus.OK;
        } catch (FishNotFoundEx e) {
            System.out.print("...DELETE exception");
            throw e;
        }
    }

    @PostMapping("/fish")
    public Fish addFish(@RequestBody Fish fishResource) throws FishExistsEx {
        try {
            System.out.print("...called POST");
            return dataRepo.addFish(fishResource.getId(), fishResource.getName(),
                    fishResource.getWeight(), fishResource.isSaltwater());
        } catch (FishExistsEx e) {
            System.out.println("...POST Exception");
            throw e;
        }
    }

    @PutMapping("/fish/{id}")
    public Fish updateFish(@PathVariable int id, @RequestBody Fish fishResource) throws FishNotFoundEx {
        try {
            System.out.print("...called PUT");
            return dataRepo.updateFish(id, fishResource.getName(),
                    fishResource.getWeight(), fishResource.isSaltwater());
        } catch (FishNotFoundEx e) {
            System.out.println("...PUT Exception");
            throw e;
        }
    }
}