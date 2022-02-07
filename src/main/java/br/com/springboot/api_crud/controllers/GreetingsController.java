package br.com.springboot.api_crud.controllers;

import java.util.List;
import java.util.Optional;

import br.com.springboot.api_crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("listartodos")
    public  ResponseEntity<List<Usuario>> buscarTodos(){
       List<Usuario> usuarios =  usuarioService.listarTodos();
	  return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
    }


    @PostMapping("salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){

      Usuario user = usuarioService.salvarUsuario(usuario);


        return new   ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }

    @PutMapping("atualizar")
    @ResponseBody  /*descrição do corpo*/
    public ResponseEntity<?> atualizarUsuario(@RequestBody Usuario usuario){ /* REQUESTBODY = recebe os dados e seta*/

        if(usuario.getId() == null){
            return new   ResponseEntity<String>("id do usuário não deve ser nulo", HttpStatus.OK);
        }
        Usuario user1 = usuarioService.atualizarUsuario(usuario);

          return new   ResponseEntity<Usuario>(user1, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    @ResponseBody  /*descrição do corpo*/
    public ResponseEntity<String> deleteUsuario(@RequestParam Long id){ /* receber parâmetros */

         usuarioService.deleteUsuario(id);

        return new   ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    }


    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public ResponseEntity<List<Usuario>>buscarPorNome(@RequestParam(name = "name") String name){



        List<Usuario> usuario = usuarioService.buscarPorNome(name.trim().toUpperCase());

        return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);

    }







}
