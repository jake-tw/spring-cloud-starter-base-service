package com.jake.webstore.cloud.base.domain;

import lombok.Builder;

@Builder
public record ContactInfo(String email, String phone, String address) {
}
