# Account Service REST API

This REST API layer is built using Spring Boot and the application uses an in-memory H2 database as its data store.

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

The app will start running at <http://localhost:8080> and the swagger can be accessed at [Swagger URL](http://localhost:8080/api/swagger-ui.html)

## Explore Rest APIs

Please find the Swagger documenation for the API at - [Swagger Documentation](https://github.com/AshokKalidoss/AccountService/blob/master/web/resources/interfaces/swagger/swagger_definition/AccountService.yaml)

The app defines following  APIs.

    GET /api/v1/users/{userId/accounts

    POST /api/v1/accounts/{accountNumber}/transactions

Application can  be tested using the postman collection available under [Post man collection](https://github.com/AshokKalidoss/AccountService/tree/master/web/resources/postman_collection)


## BlackBox testing

#### Requirements

1. node - v10.15.3

Please navigate to the folder blackbox. Please execute the command
```bash
npm install
```

After the dependencies are installed, please execute the below command to trigger the test suite
```bash
npm test
```

##### Sample test data to test the APIs from Swagger

| User ID      | Account Numbers|
| ------------- |:-------------:| -----:|
|1001    | 10011001, 10011002, 10011003,10011004 |
| 1002     | 10021001, 10021002, 10021003, 10021004      |
| 1003 | 10031001,  10031002  |
| 1004 | No Accounts     |
