package com.example.restservice;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FaultController {

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    ResponseEntity<?> FNFEHandler(FishNotFoundEx e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).header(HttpHeaders.CONTENT_TYPE,
                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create().withStatus(HttpStatus.NOT_FOUND)
                .withTitle(HttpStatus.NOT_FOUND.name()).withDetail("nie znaleziono ryby o podanym ID"));
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.CONFLICT)
    ResponseEntity<?> FEEHandler(FishExistsEx e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).header(HttpHeaders.CONTENT_TYPE,
                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create().withStatus(HttpStatus.CONFLICT)
                .withTitle(HttpStatus.CONFLICT.name()).withDetail("ryba o podanym ID juz istnieje"));

    }
}
