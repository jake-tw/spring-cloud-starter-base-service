package com.jake.webstore.user.api.dto;

import com.jake.webstore.domain.domain.User;
import com.jake.webstore.domain.dto.BaseDto;
import lombok.Data;

@Data
public class UserDto implements BaseDto {
    private User user;
}
