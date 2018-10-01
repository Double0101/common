package org.zjgsu.common.message;

import lombok.Data;

/**
 * @author smallfish
 * @Title: ResponseData
 * @ProjectName zjgsu-parent
 * @date 18-9-14下午11:31
 */
@Data
public class ResponseData<T> {
    private boolean status;
    private int code;
    private String message;
    private T data;

    public ResponseData() {
        this.code = 200;
        this.status = true;
    }

    public ResponseData(int code) {
        this.code = code;
    }

}