package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteDetalhadoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteListResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);

}
