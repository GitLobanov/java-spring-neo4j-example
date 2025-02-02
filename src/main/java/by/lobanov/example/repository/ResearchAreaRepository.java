package by.lobanov.example.repository;

import by.lobanov.example.model.nodes.ResearchArea;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ResearchAreaRepository extends Neo4jRepository<ResearchArea, Long> {

}
