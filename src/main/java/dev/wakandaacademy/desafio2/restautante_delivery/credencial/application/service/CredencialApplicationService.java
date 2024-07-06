package dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class CredencialApplicationService implements CredencialService {

	private final CredencialRepository credencialRepository;

	@Override
	public void criaNovaCredencial(ClienteRequest clienteRequest) {
		log.info("[inicia] CredencialApplicationService - criaNovaCredencial");
        var novaCredencial = new Credencial(clienteRequest.getEmail(), clienteRequest.getSenha());
        credencialRepository.salva(novaCredencial);
        log.info("[finaliza] CredencialApplicationService - criaNovaCredencial");
	}

}
