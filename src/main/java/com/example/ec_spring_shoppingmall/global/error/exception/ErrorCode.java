package com.example.ec_spring_shoppingmall.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Author: kbs
 */

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    OK(200, HttpStatus.OK, "Ok"),

    /*400 BAD_REQUEST : 잘못된 요청 */
    BAD_REQUEST(10000, HttpStatus.BAD_REQUEST, "Bad request"),
    SPRING_BAD_REQUEST(10001, HttpStatus.BAD_REQUEST, "Spring-detected bad request"),
    VALIDATION_ERROR(10002, HttpStatus.BAD_REQUEST, "Validation error"),
    INVALID_REFRESH_TOKEN(10003, HttpStatus.BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(10004, HttpStatus.BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    CANNOT_FOLLOW_MYSELF(10005,HttpStatus.BAD_REQUEST, "자기 자신은 팔로우 할 수 없습니다"),
    DUPLICATE_USER(10006, HttpStatus.BAD_REQUEST, "이미 가입된 유저입니다."),
    INVALID_INPUT_VALUE(10007, HttpStatus.BAD_REQUEST, "잘못된 입력입니다."),
    METHOD_NOT_ALLOWED(10008, HttpStatus.BAD_REQUEST, "허용되지 않은 기능입니다."),
    NOT_FOUND(20000, HttpStatus.NOT_FOUND, "Requested resource is not found"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(20001,HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
    UNAUTHENTICATED_MEMBER(20002,HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호를 다시 확인해주세요"),
    UNAUTHORIZED_MEMBER(20003,HttpStatus.UNAUTHORIZED, "현재 계정 정보가 존재하지 않습니다"),

    /*Internal Server Error*/
    INTERNAL_ERROR(30000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error"),
    SPRING_INTERNAL_ERROR(30001, HttpStatus.INTERNAL_SERVER_ERROR, "Spring-detected internal error"),
    DATA_ACCESS_ERROR(30002, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error")
    ;

    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.name(), this.getCode());
    }

}
