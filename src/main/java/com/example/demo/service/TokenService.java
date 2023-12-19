package com.example.demo.service;

import com.example.demo.domain.Token;
import com.example.demo.domain.User;

import java.util.Optional;

public interface TokenService {
    Token generateToken(User user);
    Token addToken(Token token);
    Optional<Token> getToken(String token);
    void markTokenAsUsed(String token);
}
