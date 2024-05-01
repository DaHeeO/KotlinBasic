plugins {
	kotlin("jvm") version "1.9.21"
	id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "org.example"
version = "0.0.1"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
	useJUnitPlatform()
}
kotlin {
	jvmToolchain(17)
}
