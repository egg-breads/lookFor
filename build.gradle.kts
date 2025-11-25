plugins {
    id("java")
	id("org.springframework.boot") version "3.5.7"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.moon"
version = "0.0.1-SNAPSHOT"
description = "LookFor"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
//    maven {
//        url = uri("https://mcp-repo.mercury.com/repository/mcp/")
//    }
}

extra["springAiVersion"] = "1.0.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.ai:spring-ai-starter-model-ollama")
	compileOnly("org.projectlombok:lombok")
//	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
//	developmentOnly("org.springframework.ai:spring-ai-spring-boot-docker-compose")


    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.ai:spring-ai-starter-mcp-server")

//    implementation("io.modelcontextprotocol.sdk:mcp:0.12.1")
//    implementation("io.modelcontextprotocol.sdk:mcp-spring-webmvc:0.12.1")
//    implementation(platform("io.modelcontextprotocol.sdk:mcp-bom:0.12.1")) // BOM을 platform으로 적용 권장


    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
