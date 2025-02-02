package by.lobanov.example.service.impl;

import by.lobanov.example.mapper.ScientistMapper;
import by.lobanov.example.model.dto.CreationScientistRequestDto;
import by.lobanov.example.model.dto.GetScientistResponseDto;
import by.lobanov.example.model.nodes.Scientist;
import by.lobanov.example.repository.ScientistRepository;
import by.lobanov.example.service.ScientistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScientistServiceImpl implements ScientistService {

    private final ScientistRepository scientistRepository;
    private final ScientistMapper scientistMapper;

    @Override
    public List<GetScientistResponseDto> getAllScientist() {
        return scientistMapper.toListDtos(scientistRepository.findAll());
    }

    @Override
    public Scientist createScientist(CreationScientistRequestDto requestDto) {
        Scientist newScientist = scientistMapper.toEntityFromCreationRequestDto(requestDto);
        return scientistRepository.save(newScientist);
    }
}
