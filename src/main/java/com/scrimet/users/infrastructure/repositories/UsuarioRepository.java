package com.scrimet.users.infrastructure.repositories;

import com.scrimet.users.infrastructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//como não tem delete por email e nem findByEmail no jpaRepository é necessário criar
public interface UsuarioRepository extends JpaRepository<Usuario, String>
{
    //o optional é bom para evital o null exception, caso não tenha ele lida numa boa
 Optional<Usuario> findByEmail(String email);

 // a anotação abaixo ela serve para não deletar caso tenha algum erro
 @Transactional
    void  deleteByEmail(String email);
}

