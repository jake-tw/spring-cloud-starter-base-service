package com.jake.webstore.user.api.dto;

import com.jake.webstore.common.api.domain.User;
import com.jake.webstore.common.api.dto.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class UserListDto implements BaseDto {
    private List<User> userList;
}
