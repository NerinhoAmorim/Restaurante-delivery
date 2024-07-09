package dev.wakandaacademy.desafio2.restautante_delivery.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
import dev.wakandaacademy.desafio2.restautante_delivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteMongoSpringRepository clienteMongoSpringRepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salva");
		try {
			clienteMongoSpringRepository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados.");
		}
		log.info("[finaliza] ClienteInfraRepository - salva");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
        List<Cliente> clientes = clienteMongoSpringRepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
        return clientes;
	}

	@Override
	public Cliente buscaClientePorId(UUID idCliente) {
		 log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
	        Cliente cliente = clienteMongoSpringRepository.findById(idCliente)
	                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	        log.info("[finaliza] ClienteInfraRepository - buscaClientePorId");
	        return cliente;
	}

}
