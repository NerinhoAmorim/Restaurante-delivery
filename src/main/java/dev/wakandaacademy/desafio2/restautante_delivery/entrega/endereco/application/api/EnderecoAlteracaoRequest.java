package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api;

import lombok.Value;

@Value
public class EnderecoAlteracaoRequest {
	private String estado;
	private String cidade;
	private String rua;
	private Integer numero;
	private String complemento;
	private String pontoReferencia;

}
