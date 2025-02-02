package by.lobanov.example.model.dto;

public record GetPublicationResponseDto(
        String title,
        String journal,
        Integer year
) {
}
