# Tennis Game

A Java implementation of a tennis scoring system, built as a code kata exercise using TDD approach.

## Technologies

- Java 21
- Spring Boot 3.2.4
- OpenAPI / Swagger for API documentation

## Getting Started

### Prerequisites

- Java 21 JDK
- Maven

### Running the Application

1. Clone the repository
2. Build the project:
   ```
   mvn clean install
   ```
3. Run the application:
   ```
   mvn spring-boot:run
   ```

The server will start at `http://localhost:8080`

## API Endpoints

The API is available at `http://localhost:8080/tennis-game/api/v1`

| Endpoint | Method | Description | Parameters |
|----------|--------|-------------|------------|
| `/new-game` | POST | Start a new tennis game | `player1`: Name of player one<br>`player2`: Name of player two |
| `/point/{playerName}` | POST | Record a point scored by a player | `playerName`: Name of the scoring player |
| `/score` | GET | Get the current game score | None |

You can also explore the API using Swagger UI at: `http://localhost:8080/swagger-ui.html`

## Example Usage

```http
# Start a new game
POST http://localhost:8080/tennis-game/api/v1/new-game?player1=Hannibal&player2=Clarice

# Player scores a point
POST http://localhost:8080/tennis-game/api/v1/point/Hannibal

# Get current score
GET http://localhost:8080/tennis-game/api/v1/score
```

## Project Structure

The project follows a hexagonal architecture pattern:
- `domain`: Contains the core business logic and domain models
- `application`: Spring Boot application configuration
- `rest`: REST API controllers and exception handlers

## Testing

Run the tests using:
```
mvn test
```
