plugins {
    id("org.springframework.boot") apply false
    kotlin("jvm")
    kotlin("plugin.spring") apply false
    id("io.spring.dependency-management") apply false
    id("com.github.node-gradle.node") apply false
    id("com.github.ben-manes.versions")
    id("com.adarshr.test-logger")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(14))
    }
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    apply(plugin = "com.adarshr.test-logger")

    val isIdea = System.getProperty("idea.version") != null

    testlogger {
        setTheme(if (isIdea) "plain" else "mocha-parallel")
        isShowFullStackTraces = false
        slowThreshold = 1_000
    }
}

subprojects {
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                apiVersion = "1.4"
                languageVersion = "1.4"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }
        withType<Test> {
            useJUnitPlatform()
            testLogging {
                events("passed", "skipped", "failed")
            }
        }
    }
}

tasks {
    val startDev by creating {
        group = "Application"
        description = "Start development mode with hot reload on backend and frontend."
        dependsOn(":frontend:yarn_start", ":backend:start")
    }
}
