package dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.application.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.domain.Token;
import dev.wakandaacademy.desafio2.restautante_delivery.config.security.service.TokenService;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service.CredencialService;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AutenticacaoApplicationService implements AutenticacaoService {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final CredencialService credencialService;

	@Override
	public Token autentica(UsernamePasswordAuthenticationToken userCredencials) {
		log.info("[inicia] AutenticacaoApplicationService - autentica");
		Authentication auth = authenticationManager.authenticate(userCredencials);
		Token token = Token.builder().tipo("Bearer").token(tokenService.gerarToken(auth)).build();
		log.info("[finaliza] AutenticacaoApplicationService - autentica");
		return token;
	}

	@Override
	public Token reativaToken(String tokenExpirado) {
		log.info("[inicia] AutenticacaoApplicationService - reativaToken");
		var email = extraiUsuario(tokenExpirado);
		Credencial credencial = credencialService.buscaCredencialPorEmail(email);
		log.info("[finaliza] AutenticacaoApplicationService - reativaToken");
		return Token.builder().tipo("Bearer").token(tokenService.gerarToken(credencial)).build();
	}

	private String extraiUsuario(String tokenExpirado) {
		return tokenService.getSubject(tokenExpirado);
	}

}
