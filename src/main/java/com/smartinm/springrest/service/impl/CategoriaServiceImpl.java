package com.smartinm.springrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smartinm.springrest.entity.Categoria;
import com.smartinm.springrest.repository.CategoriaJpaRepository;
import com.smartinm.springrest.service.CategoriaService;


@Service
@Qualifier("categoriaServiceImpl")
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaJpaRepository categoriaJpaRepository;
	
	@Override
	public List<Categoria> listAllCategorias() {
		return categoriaJpaRepository.findAll();
	}

	@Override
	public void addCategoria(Categoria categoria) {
		categoriaJpaRepository.save(categoria);		
	}

	@Override
	public void deleteCategoria(int id) {
		categoriaJpaRepository.deleteById(id);
		
	}

	@Override
	public void updateCategoria(Categoria categoria) {
		categoriaJpaRepository.save(categoria);		
	}

	@Override
	public Categoria getCategoria(int id) {
		return categoriaJpaRepository.getOne(id);
	}

	
}
