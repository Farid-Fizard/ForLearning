package com.example.demo.repository.jdbc;

import com.example.demo.domain.Token;
import com.example.demo.repository.TokenRepository;
import com.example.demo.repository.jdbc.mapper.TokenRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;
@Repository
public class TokenRepositoryImp implements TokenRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private TokenRowMapper tokenRowMapper;

    @Override
    public Token addToken(Token token) {
        String sql = "INSERT INTO token (value, user_id, token_type_id, generation_date, expiry_date) " +
                "VALUES (null, :value, :userId, :tokenTypeId, :generationDate, :expiryDate)";
        MapSqlParameterSource params= new MapSqlParameterSource("value",token.getValue())
                .addValue("userId",token.getUser().getId())
                .addValue("tokenTypeId", token.getType().getId())
                .addValue("generationDate",token.getGenerateDate())
                .addValue("expiryDate",token.getExpiryDate());
        int count=jdbcTemplate.update(sql,params);
        if(count>0){
            System.out.println("Token added successfully");
        }else {
            throw  new RuntimeException("Token wasn't added");
        }
        return token;
    }

    @Override
    public Optional<Token> getToken(String token) {
        Optional<Token> tokenOptional= Optional.empty();
        String sql="select id, value, user_id, token_type_id, generation_date, expiry_date " +
                "from token " +
                "where value= :value";
        MapSqlParameterSource params=new MapSqlParameterSource("value",token);
        List<Token> tokenList= jdbcTemplate.query(sql,params,tokenRowMapper);
        if(!tokenList.isEmpty()){
            tokenOptional= Optional.of(tokenList.get(0));
        }
        return tokenOptional;
    }
}
