import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version ProjectConfigs.Version.KOTLIN_VERSION
    // Kotlin Annotation Processing Tool
    kotlin("kapt") version ProjectConfigs.Version.KAPT_VERSION
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = ProjectConfigs.GROUP
    version = ProjectConfigs.VERSION

    apply(plugin = "org.jetbrains.kotlin.jvm")

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


