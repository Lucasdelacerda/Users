package com.scrimet.users.controller;



import com.scrimet.users.bussines.services.UsuarioService;
import com.scrimet.users.infrastructure.entities.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    //postar, o responseEntity é para aparecer os números dos códigos de erro
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@Valid @RequestBody Usuario usuario) {
        service.salvarUserario(usuario);
        //qualquer resposta de requisição ela pode vir
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        service.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }
    //o putMapping, ele atualiza todos os campos, o patch atualiza apenas alguns campos, primeiro parametro que pede e segundo parametro o que vai ser atualizado
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorEmail(@RequestParam String email ,@RequestBody Usuario usuario) {
     service.atualizarUsuarioPorEmail(email,usuario);
             return ResponseEntity.ok().build();
    }
}

