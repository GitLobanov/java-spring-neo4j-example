package by.lobanov.example.service.impl;

import by.lobanov.example.mapper.PublicationMapper;
import by.lobanov.example.model.dto.GetPublicationResponseDto;
import by.lobanov.example.model.nodes.Publication;
import by.lobanov.example.repository.PublicationRepository;
import by.lobanov.example.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;

    @Override
    public List<GetPublicationResponseDto> getPublicationByAuthoredScientist(Long idAuthor) {
        return publicationMapper.toListGetPublicationResponseDtos(publicationRepository.findAllByAuthors(idAuthor));
    }
}
