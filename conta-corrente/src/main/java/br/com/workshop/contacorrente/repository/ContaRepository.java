package br.com.workshop.contacorrente.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.workshop.contacorrente.Enumeration.TipoContaEnum;
import br.com.workshop.contacorrente.model.Conta;

@Repository
public interface ContaRepository extends MongoRepository<Conta, String>{
	public Page<Conta> findByTipo(TipoContaEnum tipo, Pageable pageable);
}
