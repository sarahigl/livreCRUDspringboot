package com.livremysql.livremysql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livremysql.livremysql.DTO.LivreDTO;
import com.livremysql.livremysql.exception.LivreNotFoundException;
import com.livremysql.livremysql.exception.LivrefoundException;
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
        Optional<Livre> verifLivre = Optional.ofNullable(livreRepository.findByTitre(livre.getTitre()));
        if(verifLivre.isPresent()) {
            throw new LivrefoundException(livre);
        }
        return livreRepository.save(livre);
    }
    public void removeBook(Long idLong){
        livreRepository.deleteById(idLong);
    }
    public Livre getLivreById(Long id) {
        return livreRepository.findById(id)
                .orElseThrow(()-> new LivreNotFoundException(id));
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
     //affichage avec data transfert object (data selected in livreDTO)
    public Stream<LivreDTO> getLivreToDto(Long id) {
        return livreRepository.findById(id).stream()
                .map(LivreDtoWrapper::toDto);
    }
    
}
