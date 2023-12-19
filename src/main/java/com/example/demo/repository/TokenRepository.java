package com.example.demo.repository;

import com.example.demo.domain.Token;

import java.util.Optional;

public interface TokenRepository {
    Token addToken(Token token);
    Optional<Token> getToken(String token);
}
