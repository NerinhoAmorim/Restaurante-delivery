package dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.service;

import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoRequest;

public interface EnderecoService {
	void adicionaEnderecoCliente(UUID idCliente, EnderecoRequest enderecoEntrega);
	void consultaEndereco(UUID idCliente, UUID idEnderecoEntrega);

}
