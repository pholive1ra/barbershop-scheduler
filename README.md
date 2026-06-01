# Barbershop Scheduler API

API REST para gerenciamento de agendamentos de barbearia, desenvolvida com Spring Boot e PostgreSQL.

## Tecnologias

- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- PostgreSQL
- Springdoc OpenAPI (Swagger UI)

## Funcionalidades

- Cadastro e gerenciamento de barbeiros, clientes e serviços
- Agendamento de horários vinculando barbeiro, cliente e serviço
- Atualização de status do agendamento (AGENDADO, FINALIZADO, CANCELADO)
- Consulta de horários disponíveis por barbeiro e data
- Regra de negócio: barbeiro com agendamentos pendentes não pode ser removido

## Endpoints

### Barbeiros
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /barbeiros | Cadastrar barbeiro |
| GET | /barbeiros | Listar barbeiros |
| DELETE | /barbeiros/{id} | Deletar barbeiro |
| GET | /barbeiros/{id}/horarios-disponiveis?data= | Horários disponíveis por data |

### Clientes
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /clientes | Cadastrar cliente |
| GET | /clientes | Listar clientes |
| DELETE | /clientes/{id} | Deletar cliente |

### Serviços
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /servicos | Cadastrar serviço |
| GET | /servicos | Listar serviços |
| DELETE | /servicos/{id} | Deletar serviço |

### Agendamentos
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | /agendamentos | Criar agendamento |
| GET | /agendamentos | Listar agendamentos |
| PUT | /agendamentos/{id} | Atualizar status |
| DELETE | /agendamentos/{id} | Cancelar agendamento |
| GET | /agendamentos/barbeiro/{id} | Agendamentos por barbeiro |

## Como rodar localmente

### Pré-requisitos
- Java 21
- PostgreSQL
- Maven

### Configuração do banco
Crie um banco de dados PostgreSQL e configure o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Rodando o projeto
```bash
./mvnw spring-boot:run
```

### Documentação
Com o projeto rodando, acesse a documentação interativa:
http://localhost:8080/swagger-ui/index.html

<img width="1451" height="539" alt="image" src="https://github.com/user-attachments/assets/f4bd17cd-427e-4667-82a6-5e725cb67823" />
<img width="1451" height="539" alt="image" src="https://github.com/user-attachments/assets/f5ea48bc-4c31-4fd1-8e7e-e40baf98f514" />

