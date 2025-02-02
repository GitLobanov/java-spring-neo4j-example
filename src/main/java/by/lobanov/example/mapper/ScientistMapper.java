package by.lobanov.example.mapper;

import by.lobanov.example.model.dto.CreationScientistRequestDto;
import by.lobanov.example.model.dto.GetScientistResponseDto;
import by.lobanov.example.model.nodes.Scientist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScientistMapper {

    Scientist toEntity(GetScientistResponseDto getScientistResponseDto);
    GetScientistResponseDto toGetScientistResponseDto(Scientist scientist);

    List<GetScientistResponseDto> toListDtos (List<Scientist> scientist);
    Scientist toEntityFromCreationRequestDto(CreationScientistRequestDto creationScientistRequestDto);
}
