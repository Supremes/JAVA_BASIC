package org.dododo.error;

import lombok.Data;

@Data
public class ResultEntity<T> {
    private String resultCode;
    private String errMsg;

    private T data;
}
