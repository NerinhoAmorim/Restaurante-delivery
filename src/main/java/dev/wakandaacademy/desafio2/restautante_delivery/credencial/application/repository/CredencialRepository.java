package dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.repository;

import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;

public interface CredencialRepository {
	Credencial salva(Credencial credencial);
	Credencial buscaCredencialPorEmail(String email);

}
