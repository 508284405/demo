package com.example.user.gprc;

import lombok.Data;

@Data
public class HelloReply {

    private String message;

    public static HelloReply newBuilder() {
        return new HelloReply();
    }


    public HelloReply setMessage(String s) {
        this.message = s;
        return this;
    }


    public HelloReply build() {
        return this;
    }
}
