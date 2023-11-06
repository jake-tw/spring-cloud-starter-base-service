import org.springframework.boot.gradle.plugin.ResolveMainClassName
import org.springframework.boot.gradle.tasks.bundling.BootJar

version = "1.0-SNAPSHOT"

tasks {
    named<BootJar>("bootJar") {
        enabled = false
    }
    named<ResolveMainClassName>("resolveMainClassName") {
        enabled = false
    }
}
