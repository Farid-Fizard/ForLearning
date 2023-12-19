package com.example.demo.service;

import com.example.demo.domain.Token;
import com.example.demo.domain.User;
import com.example.demo.util.CommonUtility;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenServiceImpl implements TokenService{
    @Override
    public Token generateToken(User user) {
        Token token = new Token();
        token.setValue(CommonUtility.generateToken());
        token.setGenerateDate(LocalDateTime.now());
        token.setExpiryDate(LocalDateTime.now().plusDays(3));
        token.setUser(user);
        return token;
    }

    @Override
    public Token addToken(Token token) {
        return null;
    }

    @Override
    public Optional<Token> getToken(String token) {
        return Optional.empty();
    }

    @Override
    public void markTokenAsUsed(String token) {

    }
}
