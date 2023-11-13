package com.jake.webstore.user.api.dto;

import com.jake.webstore.cloud.base.domain.User;
import lombok.Builder;

import java.util.List;

@Builder
public record UserListDto(List<User> userList) {
}
