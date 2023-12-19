package com.example.demo.repository.jdbc.mapper;

import com.example.demo.domain.Token;
import com.example.demo.domain.TokenType;
import com.example.demo.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TokenRowMapper implements RowMapper<Token> {
    @Override
    public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
        Token tokenObj= new Token();
        tokenObj.setId(rs.getLong("id"));
        tokenObj.setValue(rs.getString("value"));
        tokenObj.setGenerateDate(rs.getTimestamp("generation_date").toLocalDateTime());
        tokenObj.setExpiryDate(rs.getTimestamp("expiry_date").toLocalDateTime());
        User user = new User();
        user.setId(rs.getLong("user_id"));
        tokenObj.setUser(user);

        int tokenTypeId = rs.getInt("token_type_id");
        TokenType tokenType = TokenType.fromId(tokenTypeId);
        tokenObj.setType(tokenType);

        return tokenObj;
    }
}
