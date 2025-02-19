package com.livremysql.livremysql.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.livremysql.livremysql.DTO.LivreDTO;
import com.livremysql.livremysql.model.Livre;
import com.livremysql.livremysql.service.LivreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class LivreController {
    @Autowired
    private LivreService livreService;
    @GetMapping("/livres")  
    public List<Livre> getBooks(){
        return (List<Livre>) livreService.getAllBooks();
    }
    @PostMapping("addBook")
    public void postBook(@RequestBody Livre livrejson) {
        livreService.addBook(livrejson);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long idLong) {
        livreService.removeBook(idLong);
    }
    @GetMapping("/livre/{id}")
    public Livre getById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }
    @PutMapping("/update/{id}")
    public void updateBy(@PathVariable Long id, @RequestBody Livre entity) {
       livreService.update(id, entity);
    }
    @GetMapping("/livreDto/{id}")
    public Stream<LivreDTO> getLivreDto(@PathVariable Long id) {
        return livreService.getLivreToDto(id);
    }
    
}
