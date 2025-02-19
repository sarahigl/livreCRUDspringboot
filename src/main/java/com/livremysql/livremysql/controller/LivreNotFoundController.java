package com.livremysql.livremysql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.livremysql.livremysql.exception.LivreNotFoundException;
import com.livremysql.livremysql.exception.LivrefoundException;

@RestControllerAdvice
public class LivreNotFoundController {
//permet de retourner des erreur http lorsque not found

    @ExceptionHandler(LivreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String livreNotFound(LivreNotFoundException e){
        return e.getMessage();//donc il va venir faire afficher le message de la methode de la classe livrenotfoundexception
    }
    @ExceptionHandler(LivrefoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String LivreExist(LivrefoundException e){
        return e.getMessage();
    }
}
