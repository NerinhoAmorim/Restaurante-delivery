package dev.wakandaacademy.desafio2.restautante_delivery.pedido.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.desafio2.restautante_delivery.pedido.domain.Pedido;

public interface PedidoMongoSpringRepository extends MongoRepository<Pedido, UUID> {
	List<Pedido> findAllByIdCliente(UUID idCliente);
	Optional<Pedido> findByIdClienteAndIdPedido(UUID idCliente, UUID idPedido);

}
