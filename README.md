# spring-mongodb-docker

A simple example **Spring Boot + MongoDB replica set** using Docker Compose.

You can use it as reference to run the application with docker compose on _development environment_.

This configuration supports transactions, without need to create mongodb replicas.

By example:
```kotlin
    @Transactional
    fun createPerson(person: Person): Person {
        return personRepository.save(person)
    }
```

Based on article: https://medium.com/workleap/the-only-local-mongodb-replica-set-with-docker-compose-guide-youll-ever-need-2f0b74dd8384