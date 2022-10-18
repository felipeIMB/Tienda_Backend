package com.springboot.tienda.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.tienda.app.models.Vendedor;
import com.springboot.tienda.app.repositories.VendedorRepository;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return (List<Vendedor>) vendedorRepository.findAll();
	}

}
