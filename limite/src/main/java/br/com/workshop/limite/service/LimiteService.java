package br.com.workshop.limite.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import br.com.workshop.contacorrente.model.Conta;
import br.com.workshop.limite.broker.BrokerInPut;
import br.com.workshop.limite.model.Limite;
import br.com.workshop.limite.repository.LimiteRepository;

@Service
public class LimiteService {

	private final LimiteRepository repository;
	private final BigDecimal valorLimite;

	public LimiteService( LimiteRepository repository,
			@Value("${limite.credito}") BigDecimal valorLimite) {
		this.repository = repository;
		this.valorLimite = valorLimite;
	}

	@StreamListener(target = BrokerInPut.CONTA_CORRENTE_CRIADA)
	public void consumirTopic(Conta conta) {
		Limite limite = new Limite();
		limite.setAgencia(conta.getAgencia());
		limite.setConta(conta.getNumero());
		limite.setValor(this.valorLimite);
		repository.save(limite);
	}
}