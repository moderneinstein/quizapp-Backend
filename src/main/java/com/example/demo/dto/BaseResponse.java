package com.example.demo.dto;

import lombok.*;

import java.util.List;


public class BaseResponse<T> {
    private String status;
    private String message;
    private T data;
    public BaseResponse(String status,T data) {
        this.status = status;
        this.data = data;
    }
    public BaseResponse(String status,String message)
    {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BaseResponse(){}
}
