# AI-Powered Resume Analyzer (Spring Boot + OpenAI)

AI-Powered Resume Analyzer is a Spring Boot web application that allows users to upload resumes (PDF/DOCX),
extracts the content using Apache Tika, and analyzes it using OpenAI's GPT to provide intelligent feedback.

## What This Project Showcases
- Text Extraction: Resume parsing using Apache Tika (PDF, DOCX, etc.)

- AI Integration: Resume feedback from OpenAI's GPT API (via WebClient)

- Security: JWT-based authentication for protected endpoints

- Clean Architecture: DTOs, MapStruct mappers, layered services

- Testing: Unit tests for service/controller with JUnit, Mockito, MockMvc

- Spring Boot: REST APIs, exception handling, validation

- Docker: Containerized Spring Boot API for easy deployment

##  Why I Built It
# wanted to demonstrate how I can:

- Integrate external APIs like OpenAI with real user input

- Work with file uploads, text processing, and secure APIs

- Write testable, modular code ready for real-world production

## Tech Stack
- Angular
- Java
- Spring Boot
- OpenAI API
- Apache Tika
- Lombok
- MapStruct
- JWT Auth
- PostgreSQL
- Docker

## API Endpoints
Check them out at:  
👉 `http://localhost:8080/swagger-ui.html`

##  Setup

```bash
# clone & run
https://github.com/shawilayoul/ResumeAnalyzer.git
cd resume-analyzer
./mvnw spring-boot:run
#🤝 Contributing
PRs welcome! Let's build smarter hiring tech.
# 📄 License
MIT
