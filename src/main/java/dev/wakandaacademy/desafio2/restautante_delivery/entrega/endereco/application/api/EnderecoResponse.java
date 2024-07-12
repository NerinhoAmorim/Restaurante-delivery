package dev.wakandaacademy.desafio2.restautante_delivery.entrega.endereco.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EnderecoResponse {
	private UUID idEndereco;

}
