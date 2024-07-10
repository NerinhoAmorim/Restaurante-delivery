package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/pedido")
public interface PedidoAPI {
	@PostMapping("/criaEndereco/{idCliente}")
	@ResponseStatus(code = HttpStatus.CREATED)
	PedidoResponse postClienteRealizaPedidoCriandoEndereco(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable UUID idCliente,
			@Valid @RequestBody PedidoRequestCriandoEndereco pedidoRequest);

	@PostMapping("/{idCliente}")
	@ResponseStatus(code = HttpStatus.CREATED)
	PedidoResponse postClienteRealizaPedido(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @Valid @RequestBody PedidoRequest pedidoRequest);

	@GetMapping("/{idCliente}")
	@ResponseStatus(code = HttpStatus.OK)
	List<PedidoListCliente> getTodosPedidosDoCliente(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable UUID idCliente);

	@GetMapping("/{idCliente}/{idPedido}")
	@ResponseStatus(code = HttpStatus.OK)
	PedidoDetalhadoCliente getPedidoDoClientePorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idPedido);

	@PatchMapping("/entrega/{idCliente}/{idPedido}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchEntregaPedidoDoCliente(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idPedido);

	@PatchMapping("/retiraEntrega/{idCliente}/{idPedido}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchRetiraEntregaPedidoDoCliente(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idPedido);

	@PatchMapping("/{idCliente}/{idPedido}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchPedidoDoClientePorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idPedido,
			@RequestBody PedidoAlteracaoRequest pedidoAlteracaoRequest);

	@DeleteMapping("/{idCliente}/{idPedido}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletePedidoDoClientePorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idPedido);

}
