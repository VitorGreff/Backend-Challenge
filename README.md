## Backend Developer Challenge
This challenge was provided by @Olisaúde. I got my hands on it searching for technical exercises in the following repo: [backend challenges](https://github.com/CollabCodeTech/backend-challenges)

The goal here is basically register a series of clients (or patients) that have the following attributes:
- name
- birthdate
- gender
- health diseases (list)
- creation date
- update date
  The diseases are described by two attributes:
- name
- type (can assume 1 or 2 and is related to the disease severity)

## Endpoints
There are some basic CRUD endpoints involving the client like:
- list all clients -> **/clients**
- get one specific client (providing the id) -> **/clients/{id}**
- insert a new client -> **/clients** + the body of the new client
- delete a client from the database -> **/clients/{id}**
- update client -> **/clients/{id}** + the body of the update client
- list ten greater -> **/clients/ten-greater**
  
This last one returns the 10 patients that have the most severe health problems based on the following equation:
  $$2(1/(1+Math.exp(-2.8 + sd))) * 100$$
Where **sd** represents the score of the disease (1 or 2 based on disease type). This score is calculated inside a Client's method.

Also, it is important to notice that, for all the operations related to client, you don't need to fill all the attributes as client has a customized DTO with fewer attributes. So in the body os any clients request, you should provide:
1. name
2. birthDate
3. gender
   
All the other fields will be created (or updated) normally.

## General Structure
The project was divided by the following directories:
- **config** -> instantiate all data to work with and to run the tests
- **controller** -> controls all the http requests
- **domain** -> entities and enums (disease severity is defined as an enum)
- **dto** -> simplifies client data to work with (ignores things like creation data and update data to simplify requests)
- **exceptions** -> handle customized exceptions and all findById related problems
- **repository** -> database operations (I'm using MongoDB)
- **service** -> link both repository and controllers directories (contains business logic)