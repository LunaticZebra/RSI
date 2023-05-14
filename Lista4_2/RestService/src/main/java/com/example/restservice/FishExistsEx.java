package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class FishExistsEx extends Exception {
    public FishExistsEx(){
        super("This fish already exists");
    }
    public FishExistsEx(int id){
        super("The person with id = " + id + "already exists");
    }
}