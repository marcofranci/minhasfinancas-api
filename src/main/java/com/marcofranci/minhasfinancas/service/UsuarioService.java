package com.marcofranci.minhasfinancas.service;

import com.marcofranci.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {

	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
}
