plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

version = "1.0-SNAPSHOT"

project.getAllTasks(false).forEach {
    it.value.forEach { task -> task.enabled = false }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        implementation(project(":webstore-cloud:webstore-cloud-base"))
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}