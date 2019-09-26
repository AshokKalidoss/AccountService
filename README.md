# Account Service REST API

This project provides:

1. An API endpoint  to fetch the list of accounts for a given user
2. An API endpoint to retrieve the list of transactions for the specified account

## Requirements

1. Java - 1.8.x

2. Gradle - 5.6.2

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/AshokKalidoss/AccountService
```

**2. Build the app using gradle task**

```bash
./gradlew clean build
```

**3. Run the app using gradl task**

```bash
./gradlew clean bootRun
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following  APIs.

    GET /api/v1/users/{userId/accounts

    POST /api/v1/accounts/{accountNumber}/transactions

Application can  be tested using the postman collection.


