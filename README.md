Acessível via: `http://localhost:8080/swagger-ui.html`
# Documentação do Projeto

## Arquitetura em Camadas (Layered Architecture)
src/main/java/com/timwetech/entrevista/\
├── config/\
│   └── OpenApiConfig.java\
├── controller/\
│   └── Controller.java\Controller.java\
├── domain/\
│   ├── entity/\
│   │   └── Entity.java\
│   ├── repository/\
│   │   └── Repository.java\
│   └── service/\
│       ├── Service.java\
│       └── impl/\
│           └── ServiceImpl.java\
└── exception/\
│   └── Handler.java\
│   └── Exception.java\
└── Exception.java
## Características Implementadas

### 1. Arquitetura em Camadas
- **Controller Layer**: Responsável pelo tratamento das requisições HTTP
    - Exposição dos endpoints REST
    - Validação básica dos dados de entrada
    - Documentação Swagger

- **Service Layer**: Contém a lógica de negócio
    - Interface para baixo acoplamento
    - Implementação das regras de negócio
    - Tratamento de casos de uso

- **Repository Layer**: Acesso a dados
    - Interface que estende JpaRepository
    - Operações CRUD básicas
    - Consultas personalizadas quando necessário

- **Domain Layer**: Modelo de dados
    - Entidades JPA
    - Validações com Bean Validation
    - Anotações Lombok

### 2. Swagger/OpenAPI
- Documentação automática das APIs
- Interface interativa para teste dos endpoints
- Descrições detalhadas de operações e modelos
- Acessível via: `http://localhost:8080/swagger-ui.html`

### 3. CRUD Benefício
- Create: POST `/api/`
- Read: GET `/api/` e GET `/api//{id}`
- Update: PUT `/api//{id}`
- Delete: DELETE `/api//{id}`

### 4. Tratamento de Exceções (GlobalExceptionHandler)
- Tratamento centralizado de exceções
- Respostas padronizadas com ResponseEntity
- Mapeamento específico para diferentes tipos de erro
- Mensagens de erro personalizadas

### 5. Injeção de Dependência
- Uso de interfaces para baixo acoplamento
- Injeção via construtor com @RequiredArgsConstructor
- Gerenciamento pelo Spring Container

### 6. Lombok
- @Data: getters, setters, equals, hashCode
- @RequiredArgsConstructor: injeção de dependências
- @NoArgsConstructor/@AllArgsConstructor: construtores
- Redução de código boilerplate

### 7. Validações
- Validação dos campos obrigatórios
- Mensagens de erro personalizadas
- Tratamento adequado de erros de validação
