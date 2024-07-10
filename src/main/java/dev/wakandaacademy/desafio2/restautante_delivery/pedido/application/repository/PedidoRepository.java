package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;

public interface PedidoRepository {
	List<Pedido> buscaTodosPedidosDoCliente(UUID idCliente);
	Pedido salvaPedido(Pedido pedido);

}
