package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service.CredencialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final CredencialService credencialService;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteApplicationService - criaCliente");
        credencialService.criaNovaCredencial(clienteRequest);
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finaliza] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente.getIdCliente())
                .build();
	}

}
