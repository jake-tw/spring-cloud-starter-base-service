import org.springframework.boot.gradle.plugin.ResolveMainClassName
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("java-library")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}


version = "1.0-SNAPSHOT"

tasks {
    named<BootJar>("bootJar") {
        enabled = false
    }
    named<ResolveMainClassName>("resolveMainClassName") {
        enabled = false
    }
}

dependencies {
    apply(plugin = "java-library")
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-security")
    api("io.jsonwebtoken:jjwt:0.12.3")
}