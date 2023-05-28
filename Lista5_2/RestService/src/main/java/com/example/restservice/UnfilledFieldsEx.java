package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnfilledFieldsEx extends Exception{

    UnfilledFieldsEx() { super("All fields must be included");}
}
