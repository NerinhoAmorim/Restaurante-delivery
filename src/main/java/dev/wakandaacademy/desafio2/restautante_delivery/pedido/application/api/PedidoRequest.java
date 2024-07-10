package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PedidoRequest {
	@NotBlank
	private String produto;
	@NotBlank
	private String detalhesPedido;
	@NotNull
	private UUID idEnderecoEntrega;

}
