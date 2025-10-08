🎓 API de Matrículas em Cursos (Spring Boot)

API RESTful desenvolvida com Spring Boot que simula um sistema de matrículas para uma plataforma de cursos online.
A aplicação permite gerenciar alunos e cursos, e a principal funcionalidade é a inscrição de múltiplos alunos em múltiplos cursos, demonstrando na prática um relacionamento Many-to-Many com JPA.

✨ Conceitos e Tecnologias Aplicadas

Este projeto foi criado como exercício prático para reforçar conceitos fundamentais do ecossistema Spring e boas práticas de desenvolvimento:

API RESTful (Spring Web): construção de endpoints seguindo os padrões REST.

Spring Data JPA: persistência de dados com abstração da camada de acesso ao banco.

Relacionamento Many-to-Many: uso das anotações @ManyToMany e @JoinTable para representar tabelas de junção.

Arquitetura em 3 camadas: separação entre Controller (API), Service (lógica de negócio) e Repository (dados).

DTO (Data Transfer Object): uso de records Java para desacoplar as camadas e evitar loops de serialização.

Tratamento de exceções: gerenciamento de erros como EntityNotFoundException.

Injeção de dependências (IoC): uso do mecanismo do Spring para gerenciar componentes.

🚀 Funcionalidades

✅ CRUD de Alunos: criar e listar alunos.
✅ CRUD de Cursos: criar e listar cursos.
✅ Sistema de Matrícula: inscrever alunos em cursos (Many-to-Many).
✅ Consulta de Matrículas: listar todos os alunos matriculados em um curso específico.

🛠️ Endpoints da API

Base URL: http://localhost:8080

👩‍🎓 Alunos (/students)
Método	URL	Descrição	Exemplo de Corpo
POST	/students	Cria um novo aluno	{ "name": "Ana Silva", "email": "ana.silva@email.com" }
GET	/students	Lista todos os alunos	—
📚 Cursos (/courses)
Método	URL	Descrição	Exemplo de Corpo
POST	/courses	Cria um novo curso	{ "name": "Java para Iniciantes", "instructor": "Prof. Carlos" }
GET	/courses	Lista todos os cursos	—
🔗 Matrículas (/courses/...)
Método	URL	Descrição
POST	/courses/{courseId}/enroll/{studentId}	Matricula um aluno (studentId) em um curso (courseId)
GET	/courses/{courseId}/students	Lista todos os alunos matriculados em um curso específico
💻 Tecnologias Utilizadas

☕ Java 17+

🌱 Spring Boot 3+

🗃️ Spring Data JPA (Hibernate)

🌐 Spring Web

🧠 Lombok — para reduzir código boilerplate

🧰 Maven — gerenciamento de dependências

🧩 H2 Database — banco em memória (para testes)

🧪 Insomnia / Postman — testes da API
