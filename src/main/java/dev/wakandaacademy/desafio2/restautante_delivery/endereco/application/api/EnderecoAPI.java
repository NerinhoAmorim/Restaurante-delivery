package dev.wakandaacademy.desafio2.restautante_delivery.endereco.application.api;

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
@RequestMapping("/v1/endereco")
public interface EnderecoAPI {
	@PostMapping("/{idCliente}")
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse postEndereco(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @Valid @RequestBody EnderecoRequest enderecoRequest);

	@GetMapping("/{idCliente}")
	@ResponseStatus(code = HttpStatus.OK)
	List<EnderecoListResponse> getTodosEnderecoDoCliente(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable UUID idCliente);

	@GetMapping("/{idCliente}/{idEndereco}")
	@ResponseStatus(code = HttpStatus.OK)
	EnderecoDetalhadoResponse getEnderecoDoClientePorId(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable UUID idCliente,
			@PathVariable UUID idEndereco);

	@PatchMapping("/{idCliente}/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchEnderecoDoClientePorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idEndereco,
			@RequestBody EnderecoAlteracaoRequest enderecoAlteracaoRequest);

	@DeleteMapping("/{idCliente}/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deleteEnderecoDoClientePorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idCliente, @PathVariable UUID idEndereco);

}
