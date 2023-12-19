package com.example.demo.domain;

public enum TokenType {
    ACTIVATION(1),
    FORGOT_PASSWORD(2);
    private int id;

    TokenType(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public static TokenType fromId(int id) {
        for (TokenType tokenType : TokenType.values()) {
            if (tokenType.getId() == id) {
                return tokenType;
            }
        }
        throw new IllegalArgumentException("Invalid TokenType ID: " + id);
    }
}
