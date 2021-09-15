package com.example.demo.error;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

    private String message ;
    private String statusCode ;
    private Date time ;
    private List<String> details ;

    public ErrorResponse(String message, String statusCode, List<String> details) {
        this.message = message;
        this.statusCode = statusCode;
        this.time = new Date();
        this.details = details;
    }

    public ErrorResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
