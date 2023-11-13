package com.jake.webstore.user.api.dto;

import com.jake.webstore.cloud.base.domain.User;
import lombok.Builder;

@Builder
public record UserDto(User user) {
}
