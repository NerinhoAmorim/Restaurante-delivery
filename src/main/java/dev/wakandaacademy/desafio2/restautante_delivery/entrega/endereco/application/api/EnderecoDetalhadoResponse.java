package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api;

import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoDetalhadoResponse {
	private UUID idEndereco;
	private String estado;
	private String cidade;
	private String rua;
	private Integer numero;
	private String complemento;
	private String pontoReferencia;

	public EnderecoDetalhadoResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.pontoReferencia = endereco.getPontoReferencia();
	}

}
