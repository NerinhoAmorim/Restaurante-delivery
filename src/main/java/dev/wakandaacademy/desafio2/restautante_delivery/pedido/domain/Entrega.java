package dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entrega {
	private Boolean pedidoEntregue;
	private LocalDateTime dataHoraDaEntrega;

	public Entrega(Boolean pedidoEntregue, LocalDateTime dataHoraDaEntrega) {
		this.pedidoEntregue = pedidoEntregue;
		this.dataHoraDaEntrega = dataHoraDaEntrega;
	}

}
