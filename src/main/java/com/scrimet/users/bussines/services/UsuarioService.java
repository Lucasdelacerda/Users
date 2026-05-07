package com.scrimet.users.bussines.services;

import com.scrimet.users.infrastructure.entities.Usuario;
import com.scrimet.users.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;


    public void salvarUserario(Usuario users){

        repository.saveAndFlush(users);
    //saveAndFlush ele salva e fecha a conexão com o banco
    }

    public Usuario buscarPorEmail(String email){
        //por ser um optional é necessário colocar algum tipo de exception por aqui
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    //para esse é necessario utilizar o metodo mais cuidadoso para que não perca os dados do usuário ao salvar
    public void atualizarUsuarioPorEmail(String email, Usuario usuario){
        //primeiro vamos puxar o usuário por email utilizando o metodo que já temos acima

        Usuario usuarioEntity = buscarPorEmail(email);
        //logo após é necessário ver o que o usuário quer mudar, podemos utilizar o builder
        Usuario usuarioAtualizado = Usuario.builder()
                //aqui no email ele vai verificar se já tem um email cadastrado para puxar
                .email(usuario.getEmail() != null ?
                        usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
