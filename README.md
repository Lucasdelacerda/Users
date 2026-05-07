# Identificador de Imagens - Users

Este projeto é um serviço de backend em Spring Boot para gerenciar usuários, com a finalidade de criar e consultar dados básicos de usuários em uma aplicação Java.

## Tecnologias usadas

- Java
- Spring Boot
- Spring Data JPA
- Maven
- Banco de dados H2 ou outro configurável via `application.properties`

## Estrutura do projeto

- `src/main/java/com/scrimet/users`
  - `UsersApplication.java` - classe principal do Spring Boot
  - `controller/UsuarioController.java` - controle REST para endpoints de usuário
  - `bussines/services/UsuarioService.java` - lógica de negócio do usuário
  - `infrastructure/entities/Usuario.java` - entidade de usuário
  - `infrastructure/repositories/UsuarioRepository.java` - repositório JPA

## Como executar

1. Abra a pasta do projeto no seu IDE ou terminal.
2. Execute o comando:
   ```bash
   ./mvnw spring-boot:run
   ```
3. O serviço será inicializado em `http://localhost:8080`.

## Endpoints básicos

- `GET /usuarios` - lista todos os usuários
- `GET /usuarios/{id}` - busca um usuário por ID
- `POST /usuarios` - cria um novo usuário

> Ajuste os endpoints conforme a implementação atual do controller.

## Futuro do projeto

Este README será atualizado com as próximas melhorias planejadas:

- Adicionar `bcrypt` para hash de senhas
- Implementar tratamento de `exceptions` personalizado
- Adicionar suporte a `password` seguro no modelo de usuário
- Criar `DTOs` (Data Transfer Objects) para separar as camadas de domínio e API

## Contribuição

Contribuições são bem-vindas. Sinta-se à vontade para abrir issues ou pull requests com melhorias.

## Licença

Projeto sob a licença definida em `LICENSE`.
