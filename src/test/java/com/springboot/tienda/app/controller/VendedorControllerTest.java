package com.springboot.tienda.app.controller;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.springboot.tienda.app.controllers.VendedorRestController;
import com.springboot.tienda.app.models.Vendedor;
import com.springboot.tienda.app.services.VendedorService;

@WebMvcTest(VendedorRestController.class)
public class VendedorControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private VendedorService vendedorService;
	
	@Test
	void getAllVendedoresTest() throws Exception {
		
		Vendedor vendedor1 = new Vendedor(1, "Juana", "Marín", "19746768-1", "10-10-2000", "juana@gmail.com");
		
		// given
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		vendedores.add(vendedor1);
		when(vendedorService.findAll()).thenReturn(vendedores);
		
		// when
		mvc.perform(get("/api/vendedores").contentType(MediaType.APPLICATION_JSON))
		
		//then
		.andExpect(status().isOk())
		
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(jsonPath("$.status").value(true))
		
		.andExpect(jsonPath("$.vendedores").isNotEmpty());
		
		verify(vendedorService).findAll();
	}
	
	@Test
	void getAllVendedoresTestNoValidoConExcepcion() throws Exception {
		
		// given
		doThrow(new RuntimeException()).when(vendedorService).findAll();
		
		// when
		mvc.perform(get("/api/vendedores").contentType(MediaType.APPLICATION_JSON))
		
		//then
		.andExpect(status().isNoContent())
		
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(jsonPath("$.status").value(false))
		
		.andExpect(jsonPath("$.msje").value("Se ha producido un error al realizar la petición"));
				
	}
	
	@Test
	void getAllVendedoresTestNoValido() throws Exception {
		
		// given
		when(vendedorService.findAll()).thenReturn(null);
		
		// when
		mvc.perform(get("/api/vendedores").contentType(MediaType.APPLICATION_JSON))
		
		//then
		.andExpect(status().isNotFound())
		
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		
		.andExpect(jsonPath("$.status").value(false))
		
		.andExpect(jsonPath("$.msje").value("No se encontraron registros"));
		
		verify(vendedorService).findAll();
	}
	
	
}
