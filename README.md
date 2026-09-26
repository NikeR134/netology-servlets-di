# Netology — Servlet CRUD + Spring DI

Проект выполнен по заданиям `04_servlets` и `05_di` курса Netology.

## Технологии
- Java 17
- Maven
- Servlet API 4.0 / Tomcat 9
- Jackson
- Spring Context 5.3
- JUnit 5

## Запуск
```bash
mvn clean package
java -jar target/dependency/webapp-runner.jar target/servlets-di-homework.war
```

API: `/api/posts`
- GET `/api/posts` — список
- GET `/api/posts?id=1` — пост
- POST `/api/posts` — создание
- PUT `/api/posts` — обновление
- DELETE `/api/posts?id=1` — удаление

## Ветки
- `master` — решение 04_servlets
- `feature/webapp-runner` — WebApp Runner
- `feature/di-annotation` — Spring Annotation Config
- `feature/di-java` — Spring Java Config
