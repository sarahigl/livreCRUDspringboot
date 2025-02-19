package com.livremysql.livremysql.exception;

import com.livremysql.livremysql.model.Livre;


public class LivrefoundException extends RuntimeException{
    public LivrefoundException(Livre livre){
        super("Le livre : " + livre.getTitre() + " existe déja");
    }
}
