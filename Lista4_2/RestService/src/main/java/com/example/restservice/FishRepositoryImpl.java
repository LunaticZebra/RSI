package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class FishRepositoryImpl implements  FishRepository{
    private List<Fish> fishList;


    public FishRepositoryImpl(){
        fishList = new ArrayList<>();
        fishList.add(new Fish(1, "Łosoś", 23.5f, true));
        fishList.add(new Fish(2, "Pstrąg", 13.7f, false));

    }
    @Override
    public List<Fish> getAllFish() {
        return fishList;
    }

    @Override
    public Fish getFish(int id) throws FishNotFoundEx {
        for(Fish fish: fishList){
            if(fish.getId() == id) return fish;
        }
        throw new FishNotFoundEx();
    }

    @Override
    public Fish updateFish(int id, String name, float weight, boolean saltwater) throws FishNotFoundEx {
        for(Fish fish: fishList){
            if(fish.getId() == id){
                if(name != null) fish.setName(name);
                if(weight > 0) fish.setWeight(weight);
                fish.setSaltwater(saltwater);
                return fish;
            }
        }
        throw new FishNotFoundEx();
    }

    @Override
    public boolean deleteFish(int id) throws FishNotFoundEx {
        boolean fishRemoved = false;
        Fish fishToDelete = null;
        for(Fish fish : fishList){
            if(fish.getId() == id) {
                fishToDelete = fish;
                fishRemoved = true;
                break;
            };
        }
        fishList.remove(fishToDelete);
        if(!fishRemoved) throw new FishNotFoundEx();
        return true;
    }

    @Override
    public Fish addFish(int id, String name, float weight, boolean saltwater) throws FishExistsEx {
        for(Fish fish: fishList){
            if(fish.getId() == id) throw new FishExistsEx();
        }
        Fish fish = new Fish(id, name, weight, saltwater);
        fishList.add(fish);
        return fish;
    }

    @Override
    public int countFish() {
        return fishList.size();
    }
}