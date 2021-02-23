package com.smartinm.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartinm.springrest.entity.Categoria;
import com.smartinm.springrest.service.impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;

	@RequestMapping(value = "/all",produces = { "application/json" })
	public ResponseEntity<List<Categoria>> getCategorias(){
		
		return ResponseEntity.ok(categoriaServiceImpl.listAllCategorias());
	}
	
	@RequestMapping(value = "/add",consumes = { "application/json" })
	public ResponseEntity<Categoria> addProducto(@RequestBody Categoria categoria){
		categoriaServiceImpl.addCategoria(categoria);
		return ResponseEntity.ok(categoria);
	}
	
	@DeleteMapping(value = "/delete",consumes = { "application/json" })
	public ResponseEntity<Categoria> deleteProducto(@RequestBody Categoria categoria){
		categoriaServiceImpl.deleteCategoria(categoria.getId());
		return ResponseEntity.ok(categoria);
	}
	
	@RequestMapping(value = "/update",consumes = { "application/json" })
	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
		categoriaServiceImpl.updateCategoria(categoria);
		return ResponseEntity.ok(categoria);
	}
}
