package dev.wakandaacademy.desafio2.restautante_delivery.cliente.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.desafio2.restautante_delivery.cliente.domain.Cliente;
public interface ClienteMongoSpringRepository extends MongoRepository<Cliente, UUID> {

}
