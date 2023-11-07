package com.jake.webstore.common.api.domain;

import lombok.Data;

@Data
public class User {
    private PersonalInfo personalInfo;
    private ContactInfo contactInfo;
}
