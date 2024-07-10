package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PedidoResponse {
	private UUID idPedido;
	private UUID idCliente;

}
