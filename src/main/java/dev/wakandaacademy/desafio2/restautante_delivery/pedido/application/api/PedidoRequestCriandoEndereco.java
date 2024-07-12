package dev.wakandaacademy.desafio2.restautante_delivery.pedido.application.api;

import dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api.EnderecoRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PedidoRequestCriandoEndereco {
	@NotBlank
    private String produto;
    @NotBlank
    private String detalhesPedido;
    @NotNull
    private EnderecoRequest enderecoEntrega;

}

