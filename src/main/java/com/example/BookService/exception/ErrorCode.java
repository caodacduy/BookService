package com.example.BookService.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    UNCATEGORIZED(9999, "Lỗi chưa phân loại", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PASSWORD(1004, "Mật khẩu phải có ít nhất 8 ký tự", HttpStatus.BAD_REQUEST),
    INVALID_KEY(1001, "Khóa tin nhắn không hợp lệ", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "Người dùng đã tồn tại", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "Người dùng không tồn tại", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Chưa xác thực",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "Bạn không có quyền", HttpStatus.FORBIDDEN),
    NOT_NULL(1008,"Dữ liệu không được để trống ",HttpStatus.BAD_REQUEST),
    EMAIL_FORMAT(1008,"Sai định dạng Email ",HttpStatus.BAD_REQUEST),
    DATE_FAIL(1009,"Thời gian trả khong được trước thời gian mượn",HttpStatus.BAD_REQUEST),
    BORROW_EN(1010,"Sách đang được mượn",HttpStatus.BAD_REQUEST);

//    TOKEN_EXPIRED(1008, , );

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code ,String message, HttpStatusCode statusCode){
        this.code=code;
        this.message=message;
        this.statusCode=statusCode;
    }
}
