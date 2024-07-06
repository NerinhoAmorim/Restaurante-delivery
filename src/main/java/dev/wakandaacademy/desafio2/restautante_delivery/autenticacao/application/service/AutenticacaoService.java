package dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.application.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.domain.Token;

public interface AutenticacaoService {
	Token autentica(UsernamePasswordAuthenticationToken userCredencials);
	Token reativaToken(String tokenExpiradoValido);

}
