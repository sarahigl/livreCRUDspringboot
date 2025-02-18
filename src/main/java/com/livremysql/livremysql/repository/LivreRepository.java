package com.livremysql.livremysql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.livremysql.livremysql.model.Livre;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Long>{

}
