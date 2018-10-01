package org.zjgsu.common.message;

import lombok.Data;

/**
 * @author smallfish
 * @Title: ResponseDataFactory
 * @ProjectName zjgsu-parent
 * @date 18-9-14下午11:31
 */
@Data
public class ResponseDataFactory {

    private static class ResponseData {

        private boolean status;

        private int code;

        private String message;

        private Object data;

        public ResponseData(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public ResponseData(int code, String message, Object data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

    }

    public static ResponseData success(String message) {
        return new ResponseData(200, message);
    }

    public static ResponseData success(String message, Object data) {
        return new ResponseData(200, message, data);
    }

    public static ResponseData badRequest(String message) {
        return new ResponseData(400, message);
    }

    public static ResponseData badRequest(String message, Object data) {
        return new ResponseData(400, message, data);
    }

    public static ResponseData notFound(String message) {
        return new ResponseData(404, message);
    }

    public static ResponseData notFound(String message, Object data) {
        return new ResponseData(404, message, data);
    }

    public static ResponseData forbiden(String message) {
        return new ResponseData(403, message);
    }

    public static ResponseData forbiden(String message, Object data) {
        return new ResponseData(403, message, data);
    }

    public static ResponseData unauthorized(String message) {
        return new ResponseData(401, message);
    }

    public static ResponseData unauthorized(String message, Object data) {
        return new ResponseData(401, message, data);
    }

    public static ResponseData serverInternalError(String message) {
        return new ResponseData(500, message);
    }

    public static ResponseData serverInternalError(String message, Object data) {
        return new ResponseData(500, message, data);
    }

    public static ResponseData customerError(String message) {
        return new ResponseData(1001, message);
    }

    public static ResponseData customerError(String message, Object data) {
        return new ResponseData(1001, message, data);
    }

}