package by.lobanov.example.controller.impl;

import by.lobanov.example.controller.ScientistsController;
import by.lobanov.example.model.dto.CreationScientistRequestDto;
import by.lobanov.example.model.dto.GetPublicationResponseDto;
import by.lobanov.example.model.dto.GetScientistResponseDto;
import by.lobanov.example.model.nodes.Publication;
import by.lobanov.example.model.nodes.Scientist;
import by.lobanov.example.service.PublicationService;
import by.lobanov.example.service.ScientistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/scientists")
@RequiredArgsConstructor
public class ScientistControllerImpl implements ScientistsController {

    private final PublicationService publicationService;
    private final ScientistService scientistService;

    @Override
    @GetMapping
    public List<GetScientistResponseDto> getAllScientist() {
        return scientistService.getAllScientist();
    }

    @GetMapping("/{id}/publications")
    @Override
    public List<GetPublicationResponseDto> getAllPublicationsByScientist(@PathVariable(value = "id") Long idAuthor) {
        return publicationService.getPublicationByAuthoredScientist(idAuthor);
    }

    @PostMapping
    @Override
    public Scientist createNewScientist(CreationScientistRequestDto requestDto) {
        return scientistService.createScientist(requestDto);
    }
}
