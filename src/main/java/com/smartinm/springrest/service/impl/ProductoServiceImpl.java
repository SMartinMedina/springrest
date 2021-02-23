package com.smartinm.springrest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.smartinm.springrest.entity.Producto;
import com.smartinm.springrest.repository.ProductoJpaRepository;
import com.smartinm.springrest.service.ProductoService;



@Service
@Qualifier("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	@Qualifier("productoJpaRepository")
	ProductoJpaRepository productoJpaRepository;

	@Override
	public List<Producto> listAllProductos() {
		return productoJpaRepository.findAll();
	}

	@Override
	public void addProducto(Producto producto){
		productoJpaRepository.save(producto);
	}

	@Override
	public void deleteProducto(int id) {
		productoJpaRepository.deleteById(id);
		
	}

	@Override
	public void updateProducto(Producto producto) {
		productoJpaRepository.save(producto);		
	}

	@Override
	public Producto getProducto(int id) {
		return productoJpaRepository.getOne(id);
	}
	
	

}
