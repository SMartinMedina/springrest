package com.smartinm.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartinm.springrest.entity.Usuario;
import com.smartinm.springrest.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;

	@RequestMapping(value = "/all",produces = { "application/json" })
	public ResponseEntity<List<Usuario>> getUsuarios(){
		
		return ResponseEntity.ok(usuarioServiceImpl.listAllUsuarios());
	}
	
	@RequestMapping(value = "/add",consumes = { "application/json" })
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
		usuarioServiceImpl.addUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@DeleteMapping(value = "/delete",consumes = { "application/json" })
	public ResponseEntity<Usuario> deleteUsuario(@RequestBody Usuario usuario){
		usuarioServiceImpl.deleteUsuario(usuario.getId());
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value = "/update",consumes = { "application/json" })
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		usuarioServiceImpl.updateUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
}
