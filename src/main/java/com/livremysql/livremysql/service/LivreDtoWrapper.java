package com.livremysql.livremysql.service;

import org.springframework.stereotype.Service;

import com.livremysql.livremysql.DTO.LivreDTO;
import com.livremysql.livremysql.model.Livre;

@Service
public class LivreDtoWrapper {
    public static LivreDTO toDto(Livre livre){
        return new LivreDTO(livre.getId(), livre.getTitre(), livre.getAuteur().getFirstname(), livre.getAuteur().getLastname());
    }
}
