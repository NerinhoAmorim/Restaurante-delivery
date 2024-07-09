package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteDetalhadoResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteListResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteResponse;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service.CredencialService;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;
	private final CredencialService credencialService;
	private final PedidoRepository pedidoRepository;

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

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		 log.info("[inicia] ClienteApplicationService - buscaTodosClientes");
	        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
	        log.info("[finaliza] ClienteApplicationService - buscaTodosClientes");
	        return ClienteListResponse.converte(clientes);
	}

	@Override
	public ClienteDetalhadoResponse buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteApplicationService - buscaClientePorId");
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente);
        List<Pedido> pedidos = pedidoRepository.buscaTodosPedidosDoCliente(idCliente);
        log.info("[finaliza] ClienteApplicationService - buscaClientePorId");
        return new ClienteDetalhadoResponse(cliente, pedidos);
	}

}
