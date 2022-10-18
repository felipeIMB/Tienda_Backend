package com.springboot.tienda.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.springboot.tienda.app.models.Vendedor;
import com.springboot.tienda.app.services.VendedorService;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@Controller
@RequestMapping("/api")
public class VendedorRestController {
	
	//Se inyecta una instancia de tipo VendedorService
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping("/vendedores")
	public ResponseEntity<Map<String, Object>> getAllVendedores(@RequestParam Map<String, Object> params, Model model) {
		
		Map<String, Object>  response = new HashMap<>();
		
		List<Vendedor> vendedores = null;
		
		try {
			vendedores = vendedorService.findAll();
			
			
		}catch(RuntimeException e) {
			response.put("msje", "Se ha producido un error al realizar la petición");
			response.put("status", false);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
		}
		
		if(vendedores == null) {
			response.put("status", false);
			response.put("msje", "No se encontraron registros");
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		response.put("status", true);
		response.put("vendedores", vendedores);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK); 
		
	}
	
}
