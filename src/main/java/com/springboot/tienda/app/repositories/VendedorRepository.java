package com.springboot.tienda.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.tienda.app.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	
}
