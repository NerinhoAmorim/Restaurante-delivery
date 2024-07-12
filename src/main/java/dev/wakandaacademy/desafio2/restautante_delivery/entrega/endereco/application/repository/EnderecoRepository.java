package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	Endereco buscaEnderecoDoClientePorId(UUID idCliente, UUID idEnderecoEntrega);
	List<Endereco> buscaTodosEnderecosDoCliente(UUID idCliente);
	void deletaEndereco(Endereco endereco);

}
