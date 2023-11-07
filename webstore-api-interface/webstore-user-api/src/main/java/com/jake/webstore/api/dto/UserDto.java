package com.jake.webstore.api.dto;

import com.jake.webstore.common.api.domain.User;
import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

@Data
public class UserDto implements BaseDto {
    private User user;
}
