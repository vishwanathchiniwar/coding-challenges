@file:Suppress("LocalVariableName", "UNUSED_VARIABLE")

plugins {
    kotlin("jvm")
    id("com.github.node-gradle.node")
}

node {
    download = true
    workDir = file("$rootDir/.gradle/nodejs")
    yarnWorkDir = file("$rootDir/.gradle/yarn")
    version = "12.19.0"
    yarnVersion = "1.22.5"
}

tasks {

    val yarn_testci by getting {
        dependsOn(yarn)
    }

    val yarn_build by getting {
        mustRunAfter(yarn_testci)
        dependsOn(yarn)
    }

    build {
        dependsOn(yarn_testci, yarn_build, jar)
    }

    val jar by getting(Jar::class) {
        mustRunAfter(yarn_build)
        archiveFileName.set("${project.name}.jar")
        from(fileTree("build/assets")) { into("assets") }
        from(fileTree("build/static")) { into("static") }
        from(
            file("build/index.html"),
            file("build/asset-manifest.json"),
            file("build/manifest.json")
        )
        into("META-INF/resources")
        rename { filename -> filename.replace("index.html", "frontend.html") }
    }
}
