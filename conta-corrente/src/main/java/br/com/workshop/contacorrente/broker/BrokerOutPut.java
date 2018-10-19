package br.com.workshop.contacorrente.broker;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface BrokerOutPut {
	String CONTA_CORRENTE_CRIADA = "contaCorrenteCriada";
	
	@Output(BrokerOutPut.CONTA_CORRENTE_CRIADA)
	MessageChannel contaCorrenteCriada();
}
