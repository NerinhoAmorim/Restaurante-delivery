package dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Pedido")
public class Pedido {
	 @Id
	    private UUID idPedido;
	    @NotBlank
	    private UUID idCliente;
	    @NotBlank
	    private UUID idEnderecoEntrega;
	    @NotBlank
	    private String produto;
	    @NotBlank
	    private String detalhesPedido;
	    @NotBlank
	    private Entrega entrega;
	    private LocalDateTime dataHoraDoPedido;
	    private LocalDateTime dataHoraAlteracaoDoPedido;

}
