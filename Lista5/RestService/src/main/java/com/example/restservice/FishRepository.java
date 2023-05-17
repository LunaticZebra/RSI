package com.example.restservice;

import java.util.List;

public interface FishRepository {
    List<Fish> getAllFish();
    Fish getFish(int id) throws FishNotFoundEx;
    Fish updateFish(int id, String name, float weight, boolean saltwater) throws FishNotFoundEx;
    boolean deleteFish(int id) throws FishNotFoundEx;
    Fish addFish(int id, String name, float weight, boolean saltwater) throws FishExistsEx;
    int countFish();
}