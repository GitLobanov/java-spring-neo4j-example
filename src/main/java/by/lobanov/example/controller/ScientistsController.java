package by.lobanov.example.controller;

import by.lobanov.example.model.dto.CreationScientistRequestDto;
import by.lobanov.example.model.dto.GetPublicationResponseDto;
import by.lobanov.example.model.dto.GetScientistResponseDto;
import by.lobanov.example.model.nodes.Publication;
import by.lobanov.example.model.nodes.Scientist;

import java.util.List;

public interface ScientistsController {

    List<GetScientistResponseDto> getAllScientist();
    List<GetPublicationResponseDto> getAllPublicationsByScientist(Long idScientist);
    Scientist createNewScientist(CreationScientistRequestDto requestDto);
}
