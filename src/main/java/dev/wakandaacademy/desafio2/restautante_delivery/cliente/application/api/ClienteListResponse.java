package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {
	private String nome;
	private String telefone;

	public static List<ClienteListResponse> converte(List<Cliente> clientes) {
		return clientes.stream().map(ClienteListResponse::new).collect(Collectors.toList());
	}

	public ClienteListResponse(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
	}

}
