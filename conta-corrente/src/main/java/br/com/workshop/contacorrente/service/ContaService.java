package br.com.workshop.contacorrente.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.workshop.contacorrente.Enumeration.TipoContaEnum;
import br.com.workshop.contacorrente.broker.BrokerOutPut;
import br.com.workshop.contacorrente.model.Conta;
import br.com.workshop.contacorrente.repository.ContaRepository;

@Service
public class ContaService {

	private final CpfRemoteService cpfRemote;
	private final ContaRepository contaRepository;
	private final BrokerOutPut broker;

	/* Injetando o objeto repository atraves do construtor */
	public ContaService(ContaRepository contaRepository, CpfRemoteService cpfRemote, BrokerOutPut brokerOutPut) {
		this.contaRepository = contaRepository;
		this.cpfRemote = cpfRemote;
		this.broker = brokerOutPut;
	}

	public Conta insert(Conta conta) {
		cpfRemote.findNomeByCpf(conta.getCpf()).ifPresent(result -> conta.setNome(result.get("name")));
		final Conta result = contaRepository.save(conta);
		broker.contaCorrenteCriada().send(MessageBuilder.withPayload(result).build());
		return result;
	}

	public Optional<Conta> findById(String id) {
		return Optional.ofNullable(contaRepository.findOne(id));
	}

	public Page<Conta> findAll(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}

	public Page<Conta> findByTipo(TipoContaEnum tipo, Pageable pageable) {
		return contaRepository.findByTipo(tipo, pageable);
	}

	public void delete(String id) {
		contaRepository.delete(id);
	}

	public Conta update(Conta conta) {
		return contaRepository.save(conta);
	}
}
