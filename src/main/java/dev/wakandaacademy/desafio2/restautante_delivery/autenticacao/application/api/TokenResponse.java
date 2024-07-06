package dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.application.api;

import dev.wakandaacademy.desafio2.restautante_delivery.autenticacao.domain.Token;
import lombok.Value;

@Value
public class TokenResponse {
	private String token;
    private String tipo;

    public TokenResponse(Token token) {
    	this.token = token.getToken();
    	this.tipo = token.getTipo();
    }
}
