package com.jake.webstore.common.api.domain;

import com.jake.webstore.common.api.enums.TokenType;
import lombok.Data;

@Data
public class Token {
    private TokenType prefix;
    private String token;
    private long timeout;
}
