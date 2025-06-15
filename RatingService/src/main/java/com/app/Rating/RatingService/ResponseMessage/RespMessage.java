package com.app.Rating.RatingService.ResponseMessage;

public class RespMessage {
    private String message;

    public RespMessage() {
    }

    public RespMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
