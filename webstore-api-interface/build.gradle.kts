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
    named<Jar>("jar") {
        enabled = false
    }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        api(project(":webstore-common:webstore-api-utils"))
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}
