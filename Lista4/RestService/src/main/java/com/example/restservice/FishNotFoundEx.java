package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FishNotFoundEx extends Exception{
    public FishNotFoundEx(){
        super("The specified fish does not exist");
    }

    public FishNotFoundEx(int id){
        super("The person with id = " + id + "does not exist");
    }
}
