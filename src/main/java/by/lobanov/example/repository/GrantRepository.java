package by.lobanov.example.repository;

import by.lobanov.example.model.nodes.Grant;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface GrantRepository extends Neo4jRepository<Grant, Long> {

}
