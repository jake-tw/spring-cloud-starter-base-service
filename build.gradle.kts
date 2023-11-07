plugins {
    java
}

version = "1.0-SNAPSHOT"

project.getAllTasks(false).forEach {
    it.value.forEach { task -> task.enabled = false }
}

allprojects {
    extra.apply {
        set("githubProjectName", "webstore")

        set("lombokVersion", "1.18.30")
    }
}

subprojects {
    println("include sub module: ${project.name}")

    apply(plugin = "java")

    group = "com.jake.${project.extra["githubProjectName"]}"

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:${project.extra["lombokVersion"]}")
        annotationProcessor("org.projectlombok:lombok:${project.extra["lombokVersion"]}")
    }
}
