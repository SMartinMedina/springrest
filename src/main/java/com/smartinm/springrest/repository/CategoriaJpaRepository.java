package com.smartinm.springrest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartinm.springrest.entity.Categoria;

public interface CategoriaJpaRepository extends JpaRepository<Categoria, Serializable>{
	

}
