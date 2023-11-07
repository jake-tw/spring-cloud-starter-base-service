package com.jake.webstore.common.api.utils.domain;

import com.jake.webstore.common.api.utils.enums.TokenType;
import lombok.Data;

@Data
public class Token {
    private TokenType prefix;
    private String token;
    private long timeout;
}
