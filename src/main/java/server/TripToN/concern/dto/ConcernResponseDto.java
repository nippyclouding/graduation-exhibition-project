package server.TripToN.concern.dto;

import lombok.*;
import server.TripToN.concern.entity.Concern;
import server.TripToN.concern.entity.LuggageType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConcernResponseDto {
    // 결과 페이지에서 보여줄 고민 리스트
    // concern 테이블
    private Long concernId;

    private String concernTitle;

    private LuggageType luggageType;

    public static ConcernResponseDto from(Concern entity) {
        return ConcernResponseDto.builder()
                .concernId(entity.getConcernId())
                .concernTitle(entity.getConcernTitle())
                .luggageType(entity.getLuggageType())
                .build();
    }

}
