package com.smartinm.springrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smartinm.springrest.entity.Usuario;
import com.smartinm.springrest.repository.UsuarioJpaRepository;
import com.smartinm.springrest.service.UsuarioService;

@Service
@Qualifier("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioJpaRepository usuarioJpaRepository;
	
	@Override
	public List<Usuario> listAllUsuarios() {
		return usuarioJpaRepository.findAll();
	}

	@Override
	public void addUsuario(Usuario usuario) {
		usuarioJpaRepository.save(usuario);		
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioJpaRepository.deleteById(id);
		
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		usuarioJpaRepository.save(usuario);
	}

	@Override
	public Usuario getUsuario(int id) {
		return usuarioJpaRepository.getOne(id);
	}

}
