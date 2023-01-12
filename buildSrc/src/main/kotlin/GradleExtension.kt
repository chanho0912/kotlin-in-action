import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependencies: List<String>) {
    dependencies.forEach { dependency ->
        add("implementation", dependency)
    }
}