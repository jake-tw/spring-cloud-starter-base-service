package com.jake.webstore.cloud.base.domain;

import lombok.Builder;

@Builder
public record PersonalInfo(String username, String nickname) {
}
