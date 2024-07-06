package dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;

public interface CredencialService {
	void criaNovaCredencial(ClienteRequest clienteRequest);
	Credencial buscaCredencialPorEmail(String email);

}
