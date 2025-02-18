package com.livremysql.livremysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livremysql.livremysql.model.Livre;
import com.livremysql.livremysql.repository.LivreRepository;

import lombok.Data;

@Data
@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllBooks(){
        return(List<Livre>) livreRepository.findAll();
    }
    public Livre addBook(Livre livre){
        return livreRepository.save(livre);
    }
    public void removeBook(Long idLong){
        livreRepository.deleteById(idLong);
    }
    public Optional<Livre> findBook(Long idLong){
        return livreRepository.findById(idLong);
    }
    public Livre update(Long id, Livre newlivre){
        return livreRepository.findById(id)
            .map(livre -> {
                livre.setTitre(newlivre.getTitre());
                livre.setDescription(newlivre.getDescription());
                livre.setDatePublication(newlivre.getDatePublication());
                return livreRepository.save(livre);
            })
            .orElseGet(() -> {
                return livreRepository.save(newlivre);
              });
    }
    
}
