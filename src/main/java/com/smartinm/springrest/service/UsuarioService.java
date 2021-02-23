package com.smartinm.springrest.service;

import java.util.List;

import com.smartinm.springrest.entity.Usuario;

public interface UsuarioService {
	public abstract Usuario getUsuario(int id);
	public abstract List<Usuario> listAllUsuarios();
	public abstract void addUsuario(Usuario usuario);
	public abstract void deleteUsuario(int id);
	public abstract void updateUsuario(Usuario usuario);

}
