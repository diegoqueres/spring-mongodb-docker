# spring-mongodb-docker

**A MongoDB single-node replica set setup on Docker Compose with Spring Boot app**

You can use it as reference to run spring boot applications for _local development_. 

This setup allows you to create transaction-aware methods without the need to create replica instances. Like this:
```kotlin
 @Transactional
 fun save(olympicSport: OlympicSport): OlympicSport {
    return repository.save(olympicSport)
 }
```

## Prerequisites

Before you begin, you will need to have the following tools installed on your machine:

- [Git](https://git-scm.com)
- [Java JDK 17+](https://openjdk.org/)
- [Docker](https://www.docker.com/)
- [Maven](https://maven.apache.org/)
- [Curl](https://curl.se/)
- [MongoDB Shell](https://docs.mongodb.com/mongodb-shell/)

## How to Run the Project

1. **Start the Docker containers**:
   Ensure Docker is running, then use the following command to start Spring Boot and MongoDB containers:
   ```bash
   docker-compose up -d
   ```
   
   To completely remove the containers, volumes and images, you can use the following command:
   ```bash
   docker compose down --volumes --rmi all
    ```

2. **Add mongodb instance to your hosts file**:
   You must add a line in your `/etc/hosts` file to map mongodb to the localhost IP address:
   ```
   127.0.0.1 host.docker.internal
   ```
   Now you can connect to database using MongoDB Shell:
    ```bash
    mongosh --host host.docker.internal --port 27017
    ```

## API Usage

### Adding a New Sport

You can add _Volleyball_ sport using the following `POST` request:

```bash
curl --location 'http://localhost:8080/api/olympic-sports' \
--header 'Content-Type: application/json' \
--data '{
  "name": "Volleyball",
  "category": "Team Sports",
  "male": true,
  "female": false,
  "yearIntroduced": 1964,
  "countryOfOrigin": "United States",
  "disciplines": [
    {
      "name": "Indoor Volleyball",
      "basicRules": "Two teams of six players each compete to score points by grounding the ball on the opponent'\''s court, with a maximum of three touches before returning the ball.",
      "numberOfParticipants": 12
    },
    {
      "name": "Beach Volleyball",
      "basicRules": "Two teams of two players each compete on a sand court, aiming to score points by grounding the ball on the opponent'\''s side, with a maximum of three touches before returning the ball.",
      "numberOfParticipants": 2
    }
  ]
}'
```

### Listing All Sports

You can list all the sports using the following `GET` request:

```bash
curl --location 'http://localhost:8080/api/olympic-sports' \
--header 'Content-Type: application/json'
```

This will return a JSON array of all the Olympic sports currently stored in the database.

### Show Sport By Id

You can show some sport by id, using the following `GET` request:

```bash
curl --location 'http://localhost:8080/api/olympic-sports/66bd24e964a11052c43118f1' \
--header 'Content-Type: application/json'
```

This will return a JSON array of sport with id `66bd24e964a11052c43118f1` currently stored in the database:
```json
{
    "id": "66bd24e964a11052c43118f1",
    "name": "Athletics",
    "category": "Track and Field",
    "male": true,
    "female": true,
    "yearIntroduced": 1896,
    "countryOfOrigin": "Greece",
    "disciplines": [
        {
            "name": "100m Dash",
            "basicRules": "100 meters straight line race",
            "numberOfParticipants": 8
        },
        {
            "name": "Long Jump",
            "basicRules": "Horizontal jump after a running start",
            "numberOfParticipants": 12
        }
    ]
}
```

## Credits

This setup example was based on **Anthony Simmon's** article: _The only local MongoDB replica set with Docker Compose guide you’ll ever need!_: https://medium.com/workleap/the-only-local-mongodb-replica-set-with-docker-compose-guide-youll-ever-need-2f0b74dd8384

I used the setup proposed in the article to run with a Spring Boot application.