package com.scrimet.users.infrastructure.repositories;

import com.scrimet.users.infrastructure.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsersRepository extends JpaRepository<Users, String>
{
    //o optional é bom para evital o null exception, caso não tenha ele lida numa boa
 Optional<Users> findByEmail(String email);
}

