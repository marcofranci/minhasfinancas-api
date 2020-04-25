package com.marcofranci.minhasfinancas.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcofranci.minhasfinancas.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//query methods
	//Optional<Usuario> findByEmail(String email);
	//boolean existsByEmailAndNome(String email, String nome);
	
	//where exists
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
}
