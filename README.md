## Example by area Scientific Research Ecosystem
### Project Description
This project is a system for managing and analyzing scientific research. It allows scientists, research organizations, and administrators to efficiently work with data about publications, citations, grants, conferences, and collaborations. Using the Neo4j graph database, the system provides powerful tools for analyzing relationships between scientists, research works, and organizations.

### Purpose of Implementation
Create a convenient platform for analyzing scientific data.
Simplify the process of finding potential collaborators for research projects.
Provide tools for analyzing citation impact and research influence.
Visualize relationships between scientists, organizations, and research topics.

### Technology Stack
- Backend : Java, Spring Boot, Spring Data Neo4j
- Database : Neo4j (Graph Database)
- API : RESTful API
- Build Tool : Maven
- Testing : JUnit, Mockito
- API Documentation : Swagger/OpenAPI

## API Endpoints
### Scientists
1. GET /api/scientists`
- Retrieve a list of all scientists.
- Example response:

```json
[
    {
        "id": 1,
        "name": "John Doe",
        "organization": "MIT"
    }
]
```


2. GET /api/scientists/{id}/publications
- Retrieve all publications by a specific scientist.
- Example response:

```json
[
  {
    "title": "AI in Healthcare",
    "journal": "Nature",
    "year": 2022
  }
]
```


3. POST /api/scientists
- Create a new scientist.
- Example request body:

```json
{
  "name": "Jane Smith",
  "organization": "Stanford"
}
```

### Publications
1. GET /api/publications
- Retrieve a list of all publications.
- Example response:

```json
[
  {
    "id": 1,
    "title": "AI in Healthcare",
    "journal": "Nature",
    "year": 2022
  }
]
```

2. GET /api/publications/{id}/citations
- Retrieve all cited works for a specific publication.
- Example response:

```json
[
  {
    "title": "Machine Learning Basics",
    "journal": "IEEE",
    "year": 2020
  }
]
```


3. POST /api/publications
- Create a new publication.
- Example request body:

```json
{
  "title": "Quantum Computing",
  "journal": "Science",
  "year": 2023,
  "authors": [1, 2]
}
```


### Grants
1. GET /api/grants
- Retrieve a list of all grants.
- Example response:

```json
[
  {
    "id": 1,
    "title": "AI Research Grant",
    "sponsor": "NSF",
    "amount": 500000,
    "startDate": "2022-01-01",
    "endDate": "2024-12-31"
  }
]
```


2. POST /api/grants
- Create a new grant. 
- Example request body:

```json
{
  "title": "Quantum Computing Research",
  "sponsor": "DARPA",
  "amount": 1000000,
  "startDate": "2023-06-01",
  "endDate": "2025-05-31"
}
```


## Database Schema

### Nodes
1. Scientist: id, name, organization
2. Publication: id, title, journal, year
3. Grant: id, title, sponsor, amount, startDate, endDate
4. ResearchArea: id, name, description
5. Conference: id, name, date, location 

### Relationships
- AUTHORED_BY : A publication is authored by a scientist.
- CITES : A publication cites another publication.
- FUNDED_BY : Research is funded by a grant.
- PRESENTED_AT : A publication is presented at a conference.
- RELATED_TO : A publication is related to a research area.
- COLLABORATES_WITH : Scientists collaborate with each other.

## How to Run the Project
### Step 1: Install Docker and Docker Compose 
##### (Optional, if want using and not have docker)

Make sure you have Docker and Docker Compose installed on your machine. You can download them from the official website:
- [Docker](https://www.docker.com/?spm=5aebb161.2ef5001f.0.0.480ec921QB59Vv)
- [Docker Compose](https://docs.docker.com/compose/install/?spm=5aebb161.2ef5001f.0.0.480ec921QB59Vv)

### Step 2: Clone the Repository
```shell
git clone https://github.com/your-repo/scientific-research-ecosystem.git
cd scientific-research-ecosystem
```

## Step 3: Set Up Neo4j Using Docker Compose
##### (If have docker of course)
##### (Or search how to download manually on machine [Official Website](https://neo4j.com/))

We will use Docker Compose to run Neo4j in a container. Below is the docker-compose.yml file that you can use to start Neo4j.

### Create `docker-compose.yml`
Create a file named docker-compose.yml in the root directory of your project and add the following content:

```yaml
version: '3.8'

services:
  neo4j:
    image: neo4j:5.9.0
    container_name: neo4j-container
    ports:
      - "7474:7474"  # HTTP port for Neo4j Browser
      - "7687:7687"  # Bolt port for database connections
    environment:
      NEO4J_AUTH: neo4j/password  # Default username: neo4j, password: password
      NEO4J_dbms_memory_heap_max__size: 1G  # Adjust memory usage if needed
    volumes:
      - neo4j-data:/data  # Persist data
      - neo4j-plugins:/plugins  # Persist plugins
    restart: always

volumes:
  neo4j-data:
  neo4j-plugins:
```

### Start Neo4j Container
Run the following command to start the Neo4j container:

docker-compose up -d

This will start Neo4j in detached mode. You can access the Neo4j browser at http://localhost:7474.

Default credentials :
Username: neo4j
Password: password

Step 4: Configure Spring Boot Application
Update the application.properties file in your Spring Boot project to connect to the Neo4j instance running in Docker:

spring.neo4j.uri=bolt://localhost:7687
spring.neo4j.authentication.username=neo4j
spring.neo4j.authentication.password=password


Step 5: Build and Run the Spring Boot Application

Build the Project :
mvn clean install

Run the Application :
mvn spring-boot:run

Step 6: Access API Documentation
Once the application is running, you can access the Swagger UI for API documentation at:
