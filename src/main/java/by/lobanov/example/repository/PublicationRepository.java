package by.lobanov.example.repository;

import by.lobanov.example.model.nodes.Publication;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PublicationRepository extends Neo4jRepository<Publication, Long> {

    List<Publication> findAllByAuthors (Long idAuthor);
}
