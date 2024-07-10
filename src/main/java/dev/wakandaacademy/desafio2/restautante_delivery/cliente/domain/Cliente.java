package dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteAlteracaoRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.desafio2.restautante_delivery.handler.APIException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collation = "Cliente")
public class Cliente {
	@Id
	private UUID idCliente;
	@Email
	@NotBlank
	@Indexed(unique = true)
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String telefone;
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;

	public Cliente(ClienteRequest clienteRequest) {
		this.idCliente = UUID.randomUUID();
		this.email = clienteRequest.getEmail();
		this.nome = clienteRequest.getNome();
		this.telefone = clienteRequest.getTelefone();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void altera(ClienteAlteracaoRequest clienteAlteracaoRequest) {
		this.nome = clienteAlteracaoRequest.getNome();
		this.telefone = clienteAlteracaoRequest.getTelefone();
		this.dataHoraDoCadastro = LocalDateTime.now();

	}

	public void validaCliente(UUID idCliente) {
		if (!this.idCliente.equals(idCliente)) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Credencial de autenticação não é válida!");
		}

	}

}
