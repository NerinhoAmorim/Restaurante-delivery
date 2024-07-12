package dev.wakandaacademy.desafio2.restautante_delivery.endereco.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.desafio2.restautante_delivery.endereco.domain.Endereco;

public interface EnderecoMongoSpringRepository extends MongoRepository<Endereco, UUID> {
	Optional<Endereco> findByIdClienteAndIdEndereco(UUID idCliente, UUID idEnderecoEntrega);
	List<Endereco> findAllByIdCliente(UUID idCliente);

}
