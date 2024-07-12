package dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service.ClienteService;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoDetalhadoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoListResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api.EnderecoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.repository.EnderecoRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {

	private final EnderecoRepository enderecoRepository;
	private final ClienteService clienteService;

	@Override
	public EnderecoResponse adicionaEnderecoCliente(UUID idCliente, EnderecoRequest enderecoEntrega) {
		log.info("[inicia] EnderecoApplicationService - adicionaEnderecoCliente");
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idCliente, enderecoEntrega));
		log.info("[finaliza] EnderecoApplicationService - adicionaEnderecoCliente");
		return EnderecoResponse.builder().idEndereco(endereco.getIdEndereco()).build();
	}

	@Override
	public Endereco consultaEndereco(UUID idCliente, UUID idEnderecoEntrega) {
		log.info("[inicia] EnderecoApplicationService - checaEndereco");
		Endereco endereco = enderecoRepository.buscaEnderecoDoClientePorId(idCliente, idEnderecoEntrega);
		log.info("[finaliza] EnderecoApplicationService - checaEndereco");
		return endereco;

	}

	@Override
	public List<EnderecoListResponse> buscaTodosEnderecosDoCliente(String token, UUID idCliente) {
		log.info("[inicia] EnderecoApplicationService - buscaTodosEnderecosDoCliente");
		clienteService.consultaCliente(token, idCliente);
		List<Endereco> enderecos = enderecoRepository.buscaTodosEnderecosDoCliente(idCliente);
		log.info("[finaliza] EnderecoApplicationService - buscaTodosEnderecosDoCliente");
		return EnderecoListResponse.converte(enderecos);
	}

	@Override
	public EnderecoDetalhadoResponse buscaEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecoDoClientePorId");
		clienteService.consultaCliente(token, idCliente);
		Endereco endereco = enderecoRepository.buscaEnderecoDoClientePorId(idCliente, idEndereco);
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecoDoClientePorId");
		return new EnderecoDetalhadoResponse(endereco);
	}

	@Override
	public void alteraEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco,
			EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoApplicationService - alteraEnderecoDoClientePorId");
		clienteService.consultaCliente(token, idCliente);
		Endereco endereco = enderecoRepository.buscaEnderecoDoClientePorId(idCliente, idEndereco);
		endereco.altera(enderecoAlteracaoRequest);
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - alteraEnderecoDoClientePorId");

	}

	@Override
	public void deletaEnderecoDoClientePorId(String token, UUID idCliente, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - deletaEnderecoDoClientePorId");
        clienteService.consultaCliente(token, idCliente);
        Endereco endereco = enderecoRepository.buscaEnderecoDoClientePorId(idCliente, idEndereco);
        enderecoRepository.deletaEndereco(endereco);
        log.info("[finaliza] EnderecoApplicationService - deletaEnderecoDoClientePorId");
		
	}

}
