package com.example.rsi_projekt;

import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    ResponseEntity<?> ConflictHandler(ConflictEx e){
        return ResponseEntity.status(HttpStatus.CONFLICT).header(HttpHeaders.CONTENT_TYPE,
                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create().withStatus(HttpStatus.CONFLICT)
                .withTitle(HttpStatus.CONFLICT.name()).withDetail("Nie mozna przejsc z obecnego stanu"));
    }

    @ResponseBody
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    ResponseEntity<?> UnfilledHandler(UnfilledFieldsEx e){
        return ResponseEntity.status(HttpStatus.CONFLICT).header(HttpHeaders.CONTENT_TYPE,
                MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE).body(Problem.create().withStatus(HttpStatus.CONFLICT)
                .withTitle(HttpStatus.CONFLICT.name()).withDetail("Nie mozna przejsc z obecnego stanu"));
    }
}
