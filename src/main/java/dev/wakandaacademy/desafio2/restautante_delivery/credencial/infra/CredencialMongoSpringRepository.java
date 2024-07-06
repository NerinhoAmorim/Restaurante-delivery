package dev.wakandaacademy.desafio2.restautante_delivery.credencial.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;

public interface CredencialMongoSpringRepository extends MongoRepository<Credencial, String>{

}
