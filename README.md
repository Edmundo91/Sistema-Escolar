# Sistema Escolar

O **Sistema Escolar** é uma aplicação web que visa gerenciar turmas, alunos, disciplinas e suas respectivas notas. Ele conta com diferentes permissões de usuários (administrador e professor), tratamento de exceções personalizado e autenticação via tokens JWT.

## Funcionalidades

- **Cadastro de Turmas**: Os administradores podem criar novas turmas.
- **Cadastro de Alunos**: Administradores podem adicionar alunos ao sistema.
- **Cadastro de Disciplinas**: Professores podem cadastrar novas disciplinas para as turmas.
- **Atribuição de Notas**: Professores podem atribuir notas aos alunos em suas respectivas disciplinas.
- **Autenticação de Usuários**: Os usuários se autenticam via JWT, com suporte a papéis de **Administrador** e **Professor**.
- **Permissões de Acesso**: Diferentes permissões de acesso são fornecidas com base no papel do usuário:
  - **Administradores** podem criar turmas, alunos e disciplinas.
  - **Professores** podem atribuir notas, mas não podem criar turmas ou gerenciar alunos.
- **Tratamento de Exceções**: A aplicação possui um sistema de tratamento de exceções personalizado que garante uma resposta amigável para erros comuns.

## Tecnologias Usadas

- **Spring Boot**: Para desenvolvimento do backend.
- **Spring Security**: Para controle de autenticação e autorização.
- **JWT (JSON Web Token)**: Para autenticação via token.
- **JPA (Java Persistence API)**: Para manipulação de banco de dados com Hibernate.
- **MySQL**: Banco de dados utilizado para persistência dos dados.

## Endpoints Principais

### Autenticação

- **POST /auth/login**: Realiza o login e retorna o token JWT.
- **POST /user/save**: Cadastra um novo usuário (Administrador).

### Turma

- **POST /turma/save**: Cria uma nova turma (Apenas Administradores).
- **GET /turma/listar**: Lista todas as turmas (Acessível para todos).

### Aluno

- **POST /aluno/save**: Cadastra um novo aluno (Apenas Administradores).
- **GET /aluno/busca**: Busca alunos por parâmetros (Acessível para todos).

### Disciplina

- **POST /disciplina/save**: Cria uma nova disciplina e a atribui a todos os boletins (Apenas Professores).

### Exceções Personalizadas

A aplicação possui tratamento de exceções para cenários como:

- **Usuário não autorizado**.
- **Dados inválidos**.
- **Recursos não encontrados**.
- **Erros internos do servidor**.

## Como Rodar o Projeto

### Pré-requisitos

- JDK 11 ou superior
- MySQL instalado e configurado
- Maven ou Gradle (dependendo da configuração do projeto)

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/Sistema-Escolar.git
