package com.example.springbootexeption.advice;

import com.example.springbootexeption.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplilcationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvaliArgument( MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach( error->{
            errorMap.put(error.getField(),error.getDefaultMessage());

        });
        return errorMap;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleBussinessException(UserNotFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
}
