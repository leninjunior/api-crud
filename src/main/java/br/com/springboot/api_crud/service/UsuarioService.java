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


    public void salvar(Usuario usuario){

            usuarioRepository.save(usuario);

    }

     public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
     }

}


