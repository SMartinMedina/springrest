package com.smartinm.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartinm.springrest.entity.Producto;
import com.smartinm.springrest.service.impl.ProductoServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	ProductoServiceImpl productoServiceImpl;

	@RequestMapping(value = "/all",produces = { "application/json" })
	public ResponseEntity<List<Producto>> getProductos(){
		
		return ResponseEntity.ok(productoServiceImpl.listAllProductos());
	}
	
	@RequestMapping(value = "/add",consumes = { "application/json" })
	public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
		productoServiceImpl.addProducto(producto);
		return ResponseEntity.ok(producto);
	}
	
	@DeleteMapping(value = "/delete",consumes = { "application/json" })
	public ResponseEntity<Producto> deleteProducto(@RequestBody Producto producto){
		productoServiceImpl.deleteProducto(producto.getId());
		return ResponseEntity.ok(producto);
	}
	
	@RequestMapping(value = "/update",consumes = { "application/json" })
	public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
		productoServiceImpl.updateProducto(producto);
		return ResponseEntity.ok(producto);
	}
}
