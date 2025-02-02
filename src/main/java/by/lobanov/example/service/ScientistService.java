package by.lobanov.example.service;

import by.lobanov.example.model.dto.CreationScientistRequestDto;
import by.lobanov.example.model.dto.GetScientistResponseDto;
import by.lobanov.example.model.nodes.Scientist;

import java.util.List;

public interface ScientistService {

    List<GetScientistResponseDto> getAllScientist ();
    Scientist createScientist(CreationScientistRequestDto requestDto);
}
