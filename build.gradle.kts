import org.jetbrains.kotlin.cli.jvm.compiler.findMainClass

allprojects  {
    repositories {
        mavenCentral()
        jcenter()
        google()
        maven(url = "https://dl.bintray.com/arrow-kt/arrow-kt/")
        maven(url = "https://oss.jfrog.org/artifactory/oss-snapshot-local/") // for SNAPSHOT builds
    }
}
buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }
}
plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("kapt") version "1.3.72"
}
val arrowVersion = "0.10.4"
dependencies {
    implementation ( "io.arrow-kt:arrow-core:$arrowVersion")
    implementation ("io.arrow-kt:arrow-fx:$arrowVersion")
    implementation ("io.arrow-kt:arrow-optics:$arrowVersion")
    implementation ("io.arrow-kt:arrow-syntax:$arrowVersion")
    kapt    ("io.arrow-kt:arrow-meta:$arrowVersion")
}
