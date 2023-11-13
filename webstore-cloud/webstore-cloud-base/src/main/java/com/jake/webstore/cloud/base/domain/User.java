package com.jake.webstore.cloud.base.domain;

import lombok.Builder;

@Builder
public record User(int id,
                   DeviceInfo deviceInfo,
                   AccountInfo accountInfo,
                   PersonalInfo personalInfo,
                   ContactInfo contactInfo) {
}
