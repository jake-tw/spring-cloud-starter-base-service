package com.jake.webstore.user.api.dto;

import com.jake.webstore.domain.domain.User;
import com.jake.webstore.domain.dto.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class UserListDto implements BaseDto {
    private List<User> userList;
}
