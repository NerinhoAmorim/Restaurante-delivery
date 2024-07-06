package dev.wakandaacademy.desafio2.restautante_delivery.credencial.infra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;
import dev.wakandaacademy.desafio2.restautante_delivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CredencialInfraRepository implements CredencialRepository {

	private final CredencialMongoSpringRepository credencialMongoSpringRepository;

	@Override
	public Credencial salva(Credencial credencial) {
		log.info("[inicia] CredencialInfraRepository - salva");
		credencialMongoSpringRepository.save(credencial);
		log.info("[finaliza] CredencialInfraRepository - salva");
		return credencial;

	}

	@Override
	public Credencial buscaCredencialPorEmail(String email) {
		log.info("[inicia] CredencialInfraRepository - buscaCredencialPorEmail");
        var credencial = credencialMongoSpringRepository.findByEmail(email)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Cliente informado!"));
        log.info("[finaliza] CredencialInfraRepository - buscaCredencialPorEmail");
        return credencial;
	}

}
