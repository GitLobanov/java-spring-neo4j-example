package by.lobanov.example.repository;

import by.lobanov.example.model.nodes.Scientist;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ScientistRepository extends Neo4jRepository<Scientist, Long> {

}
