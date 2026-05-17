package server.TripToN.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // ── 시스템 ──────────────────────────────────────────────
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "INVALID_INPUT_VALUE", "입력값이 올바르지 않습니다."),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "METHOD_NOT_ALLOWED", "지원하지 않는 HTTP 메서드입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "서버 오류가 발생했습니다."),

    // ── 고민 ──────────────────────────────────────────────
    CONCERN_NOT_FOUND(HttpStatus.NOT_FOUND, "CONCERN_NOT_FOUND", "해당 고민이 존재하지 않습니다.");

    // ── 파일 ──────────────────────────────────────────────────
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;
}
