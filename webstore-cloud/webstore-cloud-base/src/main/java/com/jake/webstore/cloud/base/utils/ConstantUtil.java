package com.jake.webstore.cloud.base.utils;

public class ConstantUtil {
    public static class Redis {
        public static final class Keys {
        }

        public static final class Prefix {
            // user:password:salt:{username}
            public static final String USER_SALT = "user:salt:";
        }
    }

    public static class Header {
        public static final String AUTHORIZATION_HEADER = "Authorization";
        public static final String BEARER = "Bearer";

    }

    public static class Token {
        // 1.5 min
        public static final int ACCESS_TOKEN_TIMEOUT_SECONDS = 90;

        // 7 days
        public static final int REFRESH_TOKEN_TIMEOUT_SECONDS = 7 * 24 * 60 * 60;
        public static final String TOKEN_PREFIX = "Jakestore";
    }

    // 5 min
    public static final int SALT_RESERVE_SECONDS = 5 * 60;
}
