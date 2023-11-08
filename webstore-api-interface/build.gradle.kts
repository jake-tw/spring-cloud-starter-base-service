plugins {
    id("java-library")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

version = "1.0-SNAPSHOT"

project.getAllTasks(false).forEach {
    it.value.forEach { task -> task.enabled = false }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    dependencies {
        api(project(":webstore-common:webstore-domain"))
        implementation("org.springframework.boot:spring-boot-starter-web")
    }
}
