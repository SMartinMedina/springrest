package com.smartinm.springrest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinm.springrest.entity.Usuario;

public interface UsuarioJpaRepository extends JpaRepository<Usuario, Serializable>{

}
