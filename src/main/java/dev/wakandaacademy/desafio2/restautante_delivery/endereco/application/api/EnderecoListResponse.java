package dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.desafio2.restautante_delivery.endereco.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoListResponse {
	private UUID idEndereco;
	private String estado;
	private String cidade;
	private String rua;
	private Integer numero;

	public static List<EnderecoListResponse> converte(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoListResponse::new).collect(Collectors.toList());
	}

	public EnderecoListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.estado = endereco.getEstado();
		this.cidade = endereco.getCidade();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
	}

}
