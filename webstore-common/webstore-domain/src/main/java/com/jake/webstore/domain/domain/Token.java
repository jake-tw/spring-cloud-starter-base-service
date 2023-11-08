package com.jake.webstore.domain.domain;

import com.jake.webstore.domain.enums.TokenType;
import lombok.Data;

@Data
public class Token {
    private TokenType type;
    private String prefix;
    private String token;
    private long timeout;
}
