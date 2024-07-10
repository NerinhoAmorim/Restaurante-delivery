package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api;

import lombok.Value;

@Value
public class ClienteAlteracaoRequest {
	private String nome;
	private String telefone;

}
