package com.springboot.tienda.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.springboot.tienda.app.models.Vendedor;
import com.springboot.tienda.app.repositories.VendedorRepository;
import com.springboot.tienda.app.services.VendedorServiceImpl;

@SpringBootTest
public class VendedorServiceImplTest {

	@Mock
	VendedorRepository vendedorRepository;
	
	@InjectMocks
	VendedorServiceImpl vendedorService;
	
	@Test
	void findAllTest() {
		
		Vendedor vendedor = new Vendedor(1, "Juana", "Marín", "19746768-1", "10-10-2000", "juana@gmail.com");
		
		// Given
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		vendedores.add(vendedor);
		when(vendedorRepository.findAll()).thenReturn(vendedores);
		
		List<Vendedor> vendedoresPrueba = vendedorService.findAll();
		
		//then
		assertEquals(1, vendedoresPrueba.size());
		verify(vendedorRepository).findAll();
		
	}
}
