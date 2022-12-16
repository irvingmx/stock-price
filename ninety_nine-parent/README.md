# ninety_nine-services - REST Services

It is a REST Microservices Layer implementing the share prices interactions and fetches

## Github repository

* agnostic-api
  https://github.com/irvingmx/ninety_nine_api

* implementation
  https://github.com/irvingmx/ninety_nine

## Swagger UI API Documentation

This Api is documented vía Swagger you can find the API Description on the following url 

* http://localhost:8080/swagger-ui.html

## Resources exposed

GET /v1/companies - getAllCompanies
GET /v1/companies/{isin} - getCompany
GET /v1/companies/{isin}/shareprices - getSharePrice
GET /v1/companies/shareprices/{isin} - getSharePriceStory
GET /v1/companies/shareprices/{isin}/{seriesTimeType} - getSharePricesStoriesByTimeSeries

# Testing

## Postman Collection

For testing purposes is provided a postman collection on root path of project named ninety_nine_services.postman_collection.json

## Populated DB

For testing purposses they are dummies data on DB, you can find them in

web-layer src/main/resources/data.sql

insert into Company (ISIN, simbol, market) values ('ES0173516115', 'REP', 'MAD');

insert into Company (ISIN, simbol, market) values ('ES0178430E18', 'TEF', 'MAD');

insert into Company (ISIN, simbol, market) values ('IT0003132476', 'ENI', 'MIL');




