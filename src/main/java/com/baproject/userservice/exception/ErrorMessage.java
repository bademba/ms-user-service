package com.baproject.userservice.exception;
import org.springframework.http.HttpStatus;

import java.util.Date;
public class ErrorMessage {
    private int status;
    private String timestamp;
    private String message;
    private String responseId;

    public ErrorMessage(int value, String timestamp, String message, String responseId) {
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }
}
