package dev.wakandaacademy.desafio2.restautante_delivery.cliente.application.api;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;
import lombok.Value;

@Value
public class ClienteDetalhadoResponse {
	private UUID idCliente;
	private String email;
	private String nome;
	private String telefone;
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraUltimaAlteracao;

	public ClienteDetalhadoResponse(Cliente cliente, List<Pedido> pedidos) {
		this.idCliente = cliente.getIdCliente();
		this.email = cliente.getEmail();
		this.nome = cliente.getEmail();
		this.telefone = cliente.getTelefone();
		this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
		this.dataHoraUltimaAlteracao = cliente.getDataHoraUltimaAlteracao();
	}
}
