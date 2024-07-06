package dev.wakandaacademy.desafio2.restautante_delivery.config.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.wakandaacademy.desafio2.restautante_delivery.config.security.domain.ValidaConteudoAuthorizationHeader;
import dev.wakandaacademy.desafio2.restautante_delivery.config.security.service.TokenService;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.application.service.CredencialService;
import dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain.Credencial;
import dev.wakandaacademy.desafio2.restautante_delivery.handler.APIException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class FiltroToken extends OncePerRequestFilter {
	private final TokenService tokenService;
	private final CredencialService credencialService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("[inicia] FiltroToen - filtrando requisição");
		String token = this.recuperaToken(request);
		autenticaCliente(token);
		log.info("[finaliza] FiltroToken - filtrando requisição");
		filterChain.doFilter(request, response);

	}

	private String recuperaToken(HttpServletRequest requestOpt) {
		log.info("[inicia] recuperaToken - extraindo o token dos cabecalhos da requisicao");
		var AuthorizationHeaderValueOpt = Optional.ofNullable(recuperaValorAuthorizationHeader(requestOpt));
		String AuthorizationHeaderValue = AuthorizationHeaderValueOpt.filter(new ValidaConteudoAuthorizationHeader())
				.orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, "Token inválido!"));
		log.info("[finaliza] recuperaToken - extraindo o token dos cabecalhos da requisicao");
		return AuthorizationHeaderValue.substring(7, AuthorizationHeaderValue.length());
	}

	private String recuperaValorAuthorizationHeader(HttpServletRequest request) {
		return Optional.ofNullable(request.getHeader("Authorization")).orElseThrow(
				() -> APIException.build(HttpStatus.FORBIDDEN, "O token não está presente na requisição!"));
	}

	private void autenticaCliente(String token) {
		log.info("[inicia] autenticacaoCliente - utilizando token válido para autenticar o usuário");
		Credencial credencial = recuperaUsuario(token);
		var authenticationToken = new UsernamePasswordAuthenticationToken(credencial, null,
				credencial.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		log.info("[finaliza] autenticacaoCliente - utilizando token válido para autenticar o usuário");

	}

	private Credencial recuperaUsuario(String token) {
		var email = tokenService.getSubject(token);
		return credencialService.buscaCredencialPorEmail(email);
	}

}
