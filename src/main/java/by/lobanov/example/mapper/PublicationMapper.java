package by.lobanov.example.mapper;

import by.lobanov.example.model.dto.GetPublicationResponseDto;
import by.lobanov.example.model.nodes.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PublicationMapper {

    Publication toEntity(GetPublicationResponseDto getPublicationResponseDto);
    GetPublicationResponseDto toGetPublicationResponseDto(Publication publication);
    List<GetPublicationResponseDto> toListGetPublicationResponseDtos(List<Publication> publication);
}