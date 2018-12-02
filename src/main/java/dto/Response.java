package dto;

import constant.ResponseStatusConstant;

public class Response {

    private ResponseStatusConstant status;
    private String message;

    public Response(ResponseStatusConstant status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseStatusConstant getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
