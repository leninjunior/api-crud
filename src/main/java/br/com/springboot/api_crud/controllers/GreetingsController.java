package br.com.springboot.api_crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.api_crud.model.Usuario;
import br.com.springboot.api_crud.service.UsuarioService;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
		@Autowired
		private UsuarioService usuarioService;
		
		
		
		
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    
    @GetMapping("/listartodos")
    public  ResponseEntity<List<Usuario>> buscarTodos(){
       List<Usuario> usuarios =  usuarioService.listarTodos();
		
       return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }
}
