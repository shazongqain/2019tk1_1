package com.example.tiku1.bean;

public class Wddy {
    private String message;

    public Wddy(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Wddy{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
