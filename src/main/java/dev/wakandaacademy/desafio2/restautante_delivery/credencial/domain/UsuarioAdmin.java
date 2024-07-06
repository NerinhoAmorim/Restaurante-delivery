package dev.wakandaacademy.desafio2.restautante_delivery.credencial.domain;

public enum UsuarioAdmin {
	ADMIN("admin"),
	CLIENTE("cliente");

	private String admin;

	UsuarioAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin() {
		return admin;
	}

}
