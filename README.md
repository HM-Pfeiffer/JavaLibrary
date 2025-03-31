# JavaLibrary

JavaLibrary is a simple library management system built with Java. It provides RESTful APIs for managing books and authors using the Javalin framework.

## Features

- Add and retrieve books and authors.
- Retrieve books with available copies.
- RESTful API with JSON request/response handling.
- Unit tests for DAO and service layers.

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/HM-Pfeiffer/JavaLibrary.git
   cd JavaLibrary

2. Build the project:
    ```
    mvn clean install
    ```

3. Run the application:
    ```
    mvn exec:java -Dexec.mainClass="Application.Application"
    ```

4. Access the API:
    Use a browser, Postman, or curl to interact with the API endpoints.
    Example:
    ```
    curl http://localhost:8080/books
    ```
    
    * Note: with homebrew, you can prettify JSON output in terminal by installing jq and then running curl with jq
    ```
    brew install jq

    curl http://localhost:8080/books | jq
    ```


## API Endpoints
- GET /books: Retrieve all books.
- POST /books: Add a new book.
- GET /books/available: Retrieve books with available copies.
- GET /authors: Retrieve all authors.
- POST /authors: Add a new author.

## Running Tests

Run unit tests with:

## Tools and Technologies
Java, Javalin, Maven, JUnit, Mockito
