package com.scrimet.users.bussines.services;

import com.scrimet.users.infrastructure.entities.Users;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    public void saveUsers(Users users){
        repository.saveAndFlush(usuario)//saveAndFlush ele salva e fecha a conexão com o banco
    }
//no caso abaixo será necessário fazer no repository pois esse metodo não tem no jpaRepository
    public Users findByEmail(String email){

    }
}
