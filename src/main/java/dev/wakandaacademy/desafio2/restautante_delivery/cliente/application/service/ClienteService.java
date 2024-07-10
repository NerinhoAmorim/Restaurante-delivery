package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteDetalhadoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteListResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	List<ClienteListResponse> buscaTodosClientes();
	ClienteDetalhadoResponse buscaClientePorId(UUID idCliente);
	void atualizaClientePorId(String token, UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
	void deletaClientePorId(String token, UUID idCliente);
	Cliente consultaCliente(String token, UUID idCliente);

}
