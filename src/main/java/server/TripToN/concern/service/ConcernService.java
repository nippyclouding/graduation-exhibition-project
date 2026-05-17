package server.TripToN.concern.service;

import org.springframework.data.domain.Sort;
import server.TripToN.concern.dto.*;
import server.TripToN.concern.entity.Concern;
import server.TripToN.concern.repository.ConcernRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConcernService {
    private final ConcernRepository concernRepository;

    @Transactional
    public void saveConcern(ConcernRequestDto dto) {
        Concern concern = Concern.builder()
                .concernTitle(dto.getConcernTitle())
                .concernContent(dto.getConcernContent())
                .luggageType(dto.getLuggageType())
                .build();
        concernRepository.save(concern);
    }

    public List<ConcernResponseDto> getConcerns() {
        return concernRepository.findAll(Sort.by("createdAt").descending()).stream()
                .filter(concern -> concern.getDeletedAt() == null)
                .map(ConcernResponseDto::from)
                .toList();
    }
}
