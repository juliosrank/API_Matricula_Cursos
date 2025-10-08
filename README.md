✨ Conceitos e Padrões Aplicados
Este projeto foi desenvolvido como um exercício prático para solidificar os seguintes conceitos e tecnologias do ecossistema Spring:

API RESTful com Spring Web: Construção de endpoints seguindo os padrões REST.

Persistência de dados com Spring Data JPA: Abstração da camada de acesso a dados usando repositórios.

Relacionamento Many-to-Many (@ManyToMany): Mapeamento de relacionamentos complexos entre entidades usando uma Tabela de Junção (@JoinTable).

Arquitetura em 3 Camadas: Separação de responsabilidades entre Controller (API), Service (lógica de negócio) e Repository (dados).

Padrão DTO (Data Transfer Object): Utilização de records Java para desacoplar a camada da API da camada de persistência, evitando loops infinitos e expondo apenas os dados necessários.

Tratamento de Exceções: Gerenciamento de casos de erro, como entidades não encontradas (EntityNotFoundException).

Injeção de Dependências: Uso do mecanismo principal do Spring para gerenciar os componentes da aplicação.

🚀 Funcionalidades
[x] CRUD de Alunos: Criar e listar alunos.

[x] CRUD de Cursos: Criar e listar cursos.

[x] Sistema de Matrícula: Matricular um aluno em um curso.

[x] Consulta de Matrículas: Listar todos os alunos matriculados em um curso específico.

🛠️ Endpoints da API
A URL base da aplicação é http://localhost:8080.

Alunos (/students)
Método	URL	Descrição	Exemplo de Corpo (Request)
POST	/students	Cria um novo aluno.	{"name": "Ana Silva", "email": "ana.silva@email.com"}
GET	/students	Lista todos os alunos.	N/A

Exportar para as Planilhas
Cursos (/courses)
Método	URL	Descrição	Exemplo de Corpo (Request)
POST	/courses	Cria um novo curso.	{"name": "Java para Iniciantes", "instructor": "Prof. Carlos"}
GET	/courses	Lista todos os cursos.	N/A

Exportar para as Planilhas
Matrículas (/courses/...)
Método	URL	Descrição
POST	/courses/{courseId}/enroll/{studentId}	Matricula um aluno (studentId) em um curso (courseId).
GET	/courses/{courseId}/students	Lista todos os alunos matriculados em um curso específico.

Exportar para as Planilhas
💻 Tecnologias Utilizadas
Java 17+

Spring Boot 3+

Spring Data JPA (com Hibernate)

Spring Web

H2 Database (Banco de dados em memória)

Maven (Gerenciador de dependências)

Lombok (Para reduzir código boilerplate)

Insomnia / Postman (Para testar a API)
