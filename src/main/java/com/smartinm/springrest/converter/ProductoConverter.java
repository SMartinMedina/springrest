package com.smartinm.springrest.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smartinm.springrest.entity.Producto;
import com.smartinm.springrest.model.ProductoModel;
import com.smartinm.springrest.service.impl.CategoriaServiceImpl;
import com.smartinm.springrest.service.impl.ProductoServiceImpl;


@Component("productoConverter")
public class ProductoConverter {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@Autowired
	CategoriaServiceImpl categoriaServiceImpl;
	
	//Entity a Model
	public ProductoModel entity2Model(Producto producto) {
		
		ProductoModel productoModel = new ProductoModel();
		
		productoModel.setId(producto.getId());
		productoModel.setNombre(producto.getNombre());
		productoModel.setIdCategoria(producto.getCategoria().getId());
		
		return productoModel;		
	}
	
	//Entity a Model
	public List<ProductoModel> entity2Model(List<Producto> productos) {
		
		List<ProductoModel> listProductoModel = new ArrayList<ProductoModel>();
		
		for(Producto p : productos) {
			ProductoModel pModel = new ProductoModel();
			pModel.setId(p.getId());
			pModel.setNombre(p.getNombre());
			pModel.setIdCategoria(p.getCategoria().getId());
			
			listProductoModel.add(pModel);
		}
		return listProductoModel;		
	}
	
	
	//Model a Entity
	public Producto model2Entity(ProductoModel productoModel) {
		
		Producto producto = new Producto();
		
		producto.setId(productoModel.getId());// != 0 ? productoModel.getId() : null);
		producto.setNombre(productoModel.getNombre());
		producto.setCategoria(categoriaServiceImpl.getCategoria(productoModel.getIdCategoria()));
		
		return producto;		
	}
	
	//Model a Entity
	public List<Producto> model2Entity(List<ProductoModel> productosModel) {
		
		List<Producto> productos = new ArrayList<Producto>();
		
		for(ProductoModel pm : productosModel) {
			Producto producto = new Producto();
			producto.setId(pm.getId());// != 0 ? productoModel.getId() : null);
			producto.setNombre(pm.getNombre());
			producto.setCategoria(categoriaServiceImpl.getCategoria(pm.getIdCategoria()));			
			productos.add(producto);
		}		
		
		return productos;		
	}
	
}
