package br.com.springboot.api_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboot.api_crud.model.Usuario;
import br.com.springboot.api_crud.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario salvarUser(Usuario usuario){

            usuarioRepository.save(usuario);

        return usuario;
    }

     public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
     }

}


