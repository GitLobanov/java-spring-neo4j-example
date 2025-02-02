package by.lobanov.example.service.impl;

import by.lobanov.example.model.nodes.Publication;
import by.lobanov.example.model.nodes.Scientist;
import by.lobanov.example.repository.PublicationRepository;
import by.lobanov.example.repository.ScientistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearchServiceImpl {

    private final ScientistRepository scientistRepository;

    private final PublicationRepository publicationRepository;

    public void createScientistAndPublication() {
        // Create a Scientist
        Scientist scientist = Scientist.builder()
                .name("Jarack Vivervil")
                .organization("MIT")
                .build();

        // Create a Publication
        Publication publication = new Publication();
        publication.setTitle("AI in Healthcare");
        publication.setJournal("Nature");
        publication.setYear(2022);

        // Establish the relationship
        publication.setAuthors(List.of(scientist));
        scientist.setPublications(List.of(publication));

        // Save to Neo4j
        scientistRepository.save(scientist);
        publicationRepository.save(publication);
    }
}
