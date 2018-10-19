package br.com.workshop.limite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshop.limite.model.Limite;

@Repository
public interface LimiteRepository extends MongoRepository<Limite, String>{
}
