package com.jake.webstore.domain.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private DeviceInfo deviceInfo;
    private AccountInfo accountInfo;
    private PersonalInfo personalInfo;
    private ContactInfo contactInfo;
}
