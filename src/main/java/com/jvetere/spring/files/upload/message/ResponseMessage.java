package com.jvetere.spring.files.upload.message;

public class ResponseMessage {
    private String message;
    public ResponseMessage(String _message) {
        message = _message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
