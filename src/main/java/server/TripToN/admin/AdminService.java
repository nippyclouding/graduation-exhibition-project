package server.TripToN.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.TripToN.admin.dto.*;
import server.TripToN.concern.entity.Concern;
import server.TripToN.concern.repository.ConcernRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final ConcernRepository concernRepository;

    public TotalCountResponseDto getTotalCount() {
        long totalConcern = concernRepository.countByDeletedAtIsNull();

        return TotalCountResponseDto.builder()
                .totalConcernCount(totalConcern)
                .build();
    }

    public Page<AdminConcernResponseDto> getConcerns(int page) {
        Page<Concern> concernPage =
                concernRepository.findAll(PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "createdAt")));
        return concernPage.map(AdminConcernResponseDto::from);
    }
}
