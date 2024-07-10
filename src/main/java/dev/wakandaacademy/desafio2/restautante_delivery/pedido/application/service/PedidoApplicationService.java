package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service.ClienteService;
import dev.wakandaacademy.desafio2.restautante_delivery.config.security.service.TokenService;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.service.EnderecoService;
import dev.wakandaacademy.desafio2.restautante_delivery.endereco.domain.Endereco;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoDetalhadoCliente;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoListCliente;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoRequestCriandoEndereco;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api.PedidoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {

	private final ClienteService clienteService;
	private final PedidoRepository pedidoRepository;
	private final EnderecoService enderecoService;
	private final TokenService tokenService;

	@Override
	public PedidoResponse clienteRealizaPedidoCriandoEndereco(String token, UUID idCliente,
			PedidoRequestCriandoEndereco pedidoRequest) {
		log.info("[inicia] PedidoApplicationService - clienteRealizaPedido");
		clienteService.consultaCliente(token, idCliente);
		Endereco endereco = new Endereco(idCliente, pedidoRequest.getEnderecoEntrega());
		Pedido pedido = pedidoRepository.salvaPedido(new Pedido(idCliente, pedidoRequest, endereco.getIdEndereco()));
		enderecoService.adicionaEnderecoCliente(idCliente, pedidoRequest.getEnderecoEntrega());
		log.info("[finaliza] PedidoApplicationService - clienteRealizaPedido");
		return PedidoResponse.builder().idPedido(pedido.getIdPedido()).idCliente(pedido.getIdCliente()).build();
	}

	@Override
	public PedidoResponse clienteRealizaPedido(String token, UUID idCliente, PedidoRequest pedidoRequest) {
		log.info("[inicia] PedidoApplicationService - clienteRealizaPedido");
		clienteService.consultaCliente(token, idCliente);
		enderecoService.consultaEndereco(idCliente, pedidoRequest.getIdEnderecoEntrega());
		Pedido pedido = pedidoRepository.salvaPedido(new Pedido(idCliente, pedidoRequest));
		log.info("[finaliza] PedidoApplicationService - clienteRealizaPedido");
		return PedidoResponse.builder().idPedido(pedido.getIdPedido()).idCliente(pedido.getIdCliente()).build();
	}

	@Override
	public List<PedidoListCliente> buscaTodosPedidosDoCliente(String token, UUID idCliente) {
		log.info("[inicia] PedidoApplicationService - buscaTodosPedidosDoCliente");
		clienteService.consultaCliente(token, idCliente);
		List<Pedido> pedidosDoCliente = pedidoRepository.buscaTodosPedidosDoCliente(idCliente);
		log.info("[finaliza] PedidoApplicationService - buscaTodosPedidosDoCliente");
		return PedidoListCliente.converte(pedidosDoCliente);
	}

	@Override
	public PedidoDetalhadoCliente buscaPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoApplicationService - buscaPedidoDoClientePorId");
		clienteService.consultaCliente(token, idCliente);
		Pedido pedido = pedidoRepository.buscaPedidoDoClientePorId(idCliente, idPedido);
		log.info("[finaliza] PedidoApplicationService - buscaPedidoDoClientePorId");
		return new PedidoDetalhadoCliente(pedido);
	}

	@Override
	public void entregaPedidoDoCliente(String token, UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoApplicationService - entregaPedidoDoCliente");
		tokenService.consultaAdmin(token);
		Pedido pedido = pedidoRepository.buscaPedidoDoClientePorId(idCliente, idPedido);
		pedido.realizaEntrega();
		pedidoRepository.salvaPedido(pedido);
		log.info("[finaliza] PedidoApplicationService - entregaPedidoDoCliente");

	}

	@Override
	public void retiraEntregaPedidoDoCliente(String token, UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoApplicationService - retiraEntregaPedidoDoCliente");
		tokenService.consultaAdmin(token);
		Pedido pedido = pedidoRepository.buscaPedidoDoClientePorId(idCliente, idPedido);
		pedido.retiraEntrega();
		pedidoRepository.salvaPedido(pedido);
		log.info("[finaliza] PedidoApplicationService - retiraEntregaPedidoDoCliente");

	}

	@Override
	public void alteraPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido,
			PedidoAlteracaoRequest pedidoAlteracaoRequest) {
		log.info("[inicia] PedidoApplicationService - alteraPedidoDoClientePorId");
		clienteService.consultaCliente(token, idCliente);
		Pedido pedido = pedidoRepository.buscaPedidoDoClientePorId(idCliente, idPedido);
		pedido.altera(pedidoAlteracaoRequest);
		pedidoRepository.salvaPedido(pedido);
		log.info("[finaliza] PedidoApplicationService - alteraPedidoDoClientePorId");

	}

	@Override
	public void deletaPedidoDoClientePorId(String token, UUID idCliente, UUID idPedido) {
		log.info("[inicia] PedidoApplicationService - deletaPedidoDoClientePorId");
        clienteService.consultaCliente(token, idCliente);
        Pedido pedido = pedidoRepository.buscaPedidoDoClientePorId(idCliente, idPedido);
        pedidoRepository.deletaPedido(pedido);
        log.info("[finaliza] PedidoApplicationService - deletaPedidoDoClientePorId");
		
	}

}
