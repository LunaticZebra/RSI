package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class ConflictEx extends Exception{
    public ConflictEx(){ super("Illegal state");
    }
}
