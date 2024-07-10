package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Entrega;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;
import lombok.Value;

@Value
public class PedidoDetalhadoCliente {
	private UUID idPedido;
	private UUID enderecoEntrega;
	private String produto;
	private String detalhesPedido;
	private Entrega entrega;
	private LocalDateTime dataHoraDoPedido;

	public PedidoDetalhadoCliente(Pedido pedido) {
		this.idPedido = pedido.getIdPedido();
		this.enderecoEntrega = pedido.getIdEnderecoEntrega();
		this.produto = pedido.getProduto();
		this.detalhesPedido = pedido.getDetalhesPedido();
		this.entrega = pedido.getEntrega();
		this.dataHoraDoPedido = pedido.getDataHoraDoPedido();
	}

}
