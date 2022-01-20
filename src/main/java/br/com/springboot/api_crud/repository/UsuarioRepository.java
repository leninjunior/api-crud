package br.com.springboot.api_crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.springboot.api_crud.model.Usuario;

import java.util.List;

@Repository
 public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

        //Pesquisar por Nome
        @Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%")
        List<Usuario>buscarPorNome(String nome);
}
