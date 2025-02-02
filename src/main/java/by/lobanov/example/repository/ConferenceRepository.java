package by.lobanov.example.repository;

import by.lobanov.example.model.nodes.Conference;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConferenceRepository extends Neo4jRepository<Conference, Long> {

}
