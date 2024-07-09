package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salva(Cliente cliente);
	List<Cliente> buscaTodosClientes();
	Cliente buscaClientePorId(UUID idCliente);

}
