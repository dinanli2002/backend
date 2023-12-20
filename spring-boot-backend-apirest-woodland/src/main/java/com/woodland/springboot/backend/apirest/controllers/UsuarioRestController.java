package com.woodland.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.woodland.springboot.backend.apirest.models.entity.Messages;
import com.woodland.springboot.backend.apirest.models.entity.Usuario;
import com.woodland.springboot.backend.apirest.models.services.IMessageService;
import com.woodland.springboot.backend.apirest.models.services.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IMessageService mensajeService;
	
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
	    Usuario usuario = null;
	    // No es necesario: result.hasErrors();
	   
	    java.util.Map<String, Object> response = new HashMap<>();
	    
	    try {
	        usuario = usuarioService.findById(id);
	    } catch (DataAccessException e) {
	        response.put("mensaje", "Error al realizar la consulta en la base de datos");
	        response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
	        return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    if (usuario == null) {
	        response.put("mensaje", "El usuario ID:".concat(id.toString().concat(" no existe en la base de datos")));
	        return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	 
	
	@PostMapping("/usuarios")
	
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		Usuario usuarioNew  =null;
		java.util.Map<String, Object> response = new HashMap<>();
		try {
			usuarioNew= usuarioService.save(usuario);
		}
		catch(DataAccessException e){
			response.put("mensaje","Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con éxito");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{id}")

	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual= usuarioService.findById(id);
		Usuario usuarioUpdated = null;
		
		
		java.util.Map<String, Object> response = new HashMap<>();
		
		
		if(usuarioActual ==null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
		try {
			
			usuarioActual.setNombreNinyo(usuario.getNombreNinyo());
			usuarioActual.setNombreTutor(usuario.getNombreTutor());
			
			usuarioActual.setEmailNinyo(usuario.getEmailNinyo());
			usuarioActual.setEmailTutor(usuario.getEmailTutor());
			
			
			usuarioUpdated = usuarioService.save(usuarioActual);
			
			
			}
		catch(DataAccessException e) {
			response.put("mensaje","Error al realizar al actualizar los datos en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		response.put("mensaje", "El usuario ha sido creado con éxito");
		response.put("usuario", usuarioUpdated);
		return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/usuarios/{id}")
	
		public ResponseEntity<?> delete(@PathVariable Long id) {
		java.util.Map<String, Object> response = new HashMap<>();
		
		Usuario usuarioActual= usuarioService.findById(id);
		if(usuarioActual ==null) {
			response.put("mensaje", "Error: no se pudo eliminar, el usuario ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
		try {
			usuarioService.delete(id);
		}
		catch(DataAccessException e) {
			response.put("mensaje","Error al eliminar los datos en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		response.put("mensaje","El usuario ha sido eliminado con exito");
		return new ResponseEntity<java.util.Map<String, Object>>(response, HttpStatus.CREATED);
	
			
		}
	
	
	 
		
	}
