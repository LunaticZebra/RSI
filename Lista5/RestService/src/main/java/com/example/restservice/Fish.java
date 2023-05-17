package com.example.restservice;

public class Fish {
    private int id;
    private String name;
    private float weight;
    private boolean saltwater;

    public Fish(){

    }

    public Fish(int id, String name, float weight, boolean saltwater) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.saltwater = saltwater;
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
}