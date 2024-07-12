package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@CompoundIndex(name = "endereco_index", def = "{'rua' : 1, 'numero' : 1}", unique = true)
@Document(collection = "Endereco")
public class Endereco {
	@Id
	private UUID idEndereco;
	@NotBlank
	private UUID idCliente;
	@NotBlank
	private String estado;
	@NotBlank
	private String cidade;
	@NotBlank
	private String rua;
	@NotNull
	private Integer numero;
	private String complemento;
	private String pontoReferencia;

	public Endereco(UUID idCliente, EnderecoRequest enderecoEntrega) {
		this.idEndereco = UUID.randomUUID();
		this.idCliente = idCliente;
		this.estado = enderecoEntrega.getEstado();
		this.cidade = enderecoEntrega.getCidade();
		this.rua = enderecoEntrega.getRua();
		this.numero = enderecoEntrega.getNumero();
		this.complemento = enderecoEntrega.getComplemento();
		this.pontoReferencia = enderecoEntrega.getPontoReferencia();

	}

	public void altera(EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		this.estado = enderecoAlteracaoRequest.getEstado();
		this.cidade = enderecoAlteracaoRequest.getCidade();
		this.rua = enderecoAlteracaoRequest.getRua();
		this.numero = enderecoAlteracaoRequest.getNumero();
		this.complemento = enderecoAlteracaoRequest.getComplemento();
		this.pontoReferencia = enderecoAlteracaoRequest.getPontoReferencia();

	}
}
