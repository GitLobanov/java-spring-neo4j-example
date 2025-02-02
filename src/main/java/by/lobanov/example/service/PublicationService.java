package by.lobanov.example.service;

import by.lobanov.example.model.dto.GetPublicationResponseDto;
import by.lobanov.example.model.nodes.Publication;

import java.util.List;

public interface PublicationService {

    List<GetPublicationResponseDto> getPublicationByAuthoredScientist (Long idAuthor);
}
