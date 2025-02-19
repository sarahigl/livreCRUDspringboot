package com.livremysql.livremysql.exception;

public class LivreNotFoundException  extends RuntimeException{
    public LivreNotFoundException(Long idLong){
        super("Livre"+idLong+"non trouvé");
    }

}
