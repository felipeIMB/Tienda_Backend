package com.springboot.tienda.app.services;

import java.util.List;
import com.springboot.tienda.app.models.Vendedor;

public interface VendedorService {
	
	public List<Vendedor> findAll();
}
