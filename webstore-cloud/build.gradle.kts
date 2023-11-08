version = "1.0-SNAPSHOT"

project.getAllTasks(false).forEach {
    it.value.forEach { task -> task.enabled = false }
}
