package org.dododo.model.VO;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResultVO<T> {
    private HttpStatus resultCode;
    private String errMsg;

    private T data;

    public static <T> ResultVO<T> ok() {
        return resultVO(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null);
    }

    public static <T> ResultVO<T> ok(T data) {
        return resultVO(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> ResultVO<T> error(String errMsg) {
        return resultVO(HttpStatus.INTERNAL_SERVER_ERROR, errMsg, null);
    }

    private static <T> ResultVO<T> resultVO(HttpStatus resultCode, String errMsg, T data) {
        return ResultVO.<T>builder()
                .resultCode(resultCode)
                .errMsg(errMsg)
                .data(data).build();
    }
}

