package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Entrega;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;
import lombok.Value;

@Value
public class PedidoListCliente {
	private String produto;
	private String detalhesPedido;
	private Entrega entrega;
	private LocalDateTime dataHoraCriacaoDoPedido;

	public static List<PedidoListCliente> converte(List<Pedido> pedidosDoCliente) {
		return pedidosDoCliente.stream().map(PedidoListCliente::new).collect(Collectors.toList());
	}

	public PedidoListCliente(Pedido pedido) {
		this.produto = pedido.getProduto();
		this.detalhesPedido = pedido.getDetalhesPedido();
		this.entrega = pedido.getEntrega();
		this.dataHoraCriacaoDoPedido = pedido.getDataHoraDoPedido();

	}

}
