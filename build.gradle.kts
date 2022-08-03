import io.qameta.allure.gradle.AllureExtension
import org.gradle.api.tasks.testing.logging.TestLogEvent

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("io.qameta.allure:allure-gradle:2.8.1")
    }
}

tasks.existing(Wrapper::class) {
    gradleVersion = "5.1.1"
    distributionType = Wrapper.DistributionType.ALL
}

group = "io.eroshenkoam"
version = version

plugins {
    java
    maven
}

apply(plugin = "io.qameta.allure")

configure<AllureExtension> {
    autoconfigure = true
    aspectjweaver = true
    version = "2.16.0"

    useJUnit5 {
        version = "2.16.0"
    }

}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {

    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")

    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
    testLogging {
        setEvents(listOf(TestLogEvent.FAILED, TestLogEvent.SKIPPED, TestLogEvent.PASSED))
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    compile("commons-io:commons-io:2.6")
    compile("io.qameta.allure:allure-java-commons:2.16.0")

    compile("org.junit.jupiter:junit-jupiter-api:5.7.0")
    compile("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    compile("org.junit.jupiter:junit-jupiter-params:5.7.0")

    testCompile("io.qameta.allure:allure-junit-platform:2.16.0")
}
