package com.jake.webstore.cloud.base.hook;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DefaultHook {

    @PostConstruct
    public void init() {
        Thread printingHook = new Thread(() -> System.out.println("Server shutdown"));
        Runtime.getRuntime().addShutdownHook(printingHook);
    }
}
