import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version ProjectConfigs.Version.KOTLIN_VERSION
    // Kotlin Annotation Processing Tool
    kotlin("kapt") version ProjectConfigs.Version.KAPT_VERSION
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    apply(plugin = Plugins.JETBRAINS_KOTLIN)

    group = ProjectConfigs.GROUP
    version = ProjectConfigs.VERSION

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(Dependencies.Libs.KOTLIN)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf(ProjectConfigs.JSR_305)
            jvmTarget = ProjectConfigs.Version.TARGET_JVM
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}


