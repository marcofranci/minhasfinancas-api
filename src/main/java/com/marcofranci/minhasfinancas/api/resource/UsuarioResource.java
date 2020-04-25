package com.marcofranci.minhasfinancas.api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcofranci.minhasfinancas.api.dto.UsuarioDTO;
import com.marcofranci.minhasfinancas.exception.ErroAutenticacao;
import com.marcofranci.minhasfinancas.exception.RegraNegocioException;
import com.marcofranci.minhasfinancas.model.entity.Usuario;
import com.marcofranci.minhasfinancas.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

	// não precisa @autowired porque o framework possui a instancia passada no
	// construtor
	private UsuarioService service;

	public UsuarioResource(UsuarioService service) {
		this.service = service;
	}

	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
		try {
			Usuario usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado); // ok = codigo 200
		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {
		Usuario usuario = Usuario.builder().nome(dto.getNome()).email(dto.getEmail()).senha(dto.getSenha()).build();

		try {
			Usuario usuarioSalvo = service.salvarUsuario(usuario);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		} catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	// codigo utilizado para verificar se o servidor esta funcionando
//	@GetMapping("/")
//	public String helloWorld() {
//		return "hello world!";
//	}

}
