package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoDetalhadoCliente;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoListCliente;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoRequestCriandoEndereco;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoResponse;

public interface PedidoService {
	PedidoResponse clienteRealizaPedidoCriandoEndereco(String token, UUID idCliente,
			PedidoRequestCriandoEndereco pedidoRequest);
	PedidoResponse clienteRealizaPedido(String token, UUID idCliente, PedidoRequest pedidoRequest);
	List<PedidoListCliente> buscaTodosPedidosDoCliente(String token, UUID idCliente);
	PedidoDetalhadoCliente buscaPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido);
	void entregaPedidoDoCliente(String token, UUID idCliente, UUID idPedido);
	void retiraEntregaPedidoDoCliente(String token, UUID idCliente, UUID idPedido);
	void alteraPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido,
			PedidoAlteracaoRequest pedidoAlteracaoRequest);
	void deletaPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido);

}
