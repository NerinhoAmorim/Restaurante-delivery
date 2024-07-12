package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.repository.EnderecoRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.domain.Endereco;
import dev.wakandaacademy.desafio2.restautante_delivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {

	private final EnderecoMongoSpringRepository enderecoMongoSpringRepository;

	@Override
	public Endereco salvaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository criaEndereco");
		try {
			 enderecoMongoSpringRepository.save(endereco);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Já existe um endereço com a mesma rua e número.");
		}
		log.info("[finaliza] EnderecoInfraRepository criaEndereco");
		return endereco;
	}
	@Override
	public List<Endereco> buscaTodosEnderecosDoCliente(UUID idCliente) {
		log.info("[inicia] EnderecoInfraRepository - buscaTodosEnderecosDoCliente");
        List<Endereco> enderecosDoCliente = enderecoMongoSpringRepository.findAllByIdCliente(idCliente);
        log.info("[finaliza] EnderecoInfraRepository - buscaTodosEnderecosDoCliente");
        return enderecosDoCliente;
	}

	@Override
	public Endereco buscaEnderecoDoClientePorId(UUID idCliente, UUID idEnderecoEntrega) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecoDoClientePorId");
        Endereco endereco = enderecoMongoSpringRepository.findByIdClienteAndIdEndereco(idCliente, idEnderecoEntrega)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereço não encontrado."));
        log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoDoClientePorId");
        return endereco;
	}
	@Override
	public void deletaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - deletaEndereco");
        enderecoMongoSpringRepository.delete(endereco);
        log.info("[finaliza] EnderecoInfraRepository - deletaEndereco");
		
	}


}
