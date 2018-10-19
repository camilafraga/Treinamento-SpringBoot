package br.com.workshop.limite.broker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface BrokerInPut {
	String CONTA_CORRENTE_CRIADA = "contaCorrenteCriada";

	@Input(BrokerInPut.CONTA_CORRENTE_CRIADA)
	SubscribableChannel contaCorrenteCriada();
}
