package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoDetalhadoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoListResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.domain.Endereco;

public interface EnderecoService {
	EnderecoResponse adicionaEnderecoCliente(UUID idCliente, EnderecoRequest enderecoEntrega);
	List<EnderecoListResponse> buscaTodosEnderecosDoCliente(String token, UUID idCliente);
	Endereco consultaEndereco(UUID idCliente, UUID idEnderecoEntrega);
	EnderecoDetalhadoResponse buscaEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco);
	void alteraEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco,
			EnderecoAlteracaoRequest enderecoAlteracaoRequest);
	void deletaEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco);

}
