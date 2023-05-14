package com.example.restservice;

enum FishStatus {
    FROZEN,
    ORDERED,
    COOKED,
    PAID
}
public class Fish {
    private int id;
    private String name;
    private float weight;
    private boolean saltwater;

    private FishStatus fishStatus;

    public Fish(){

    }

    public Fish(int id, String name, float weight, boolean saltwater) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.saltwater = saltwater;
        this.fishStatus = FishStatus.FROZEN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSaltwater() {
        return saltwater;
    }

    public void setSaltwater(boolean saltwater) {
        this.saltwater = saltwater;
    }

    public void setFishStatus(FishStatus fishStatus) {this.fishStatus = fishStatus; }

    public FishStatus getFishStatus() {return fishStatus; }
}