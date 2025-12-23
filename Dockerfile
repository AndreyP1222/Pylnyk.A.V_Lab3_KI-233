# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B -q

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests -q

# Stage 2: Extract layers
FROM eclipse-temurin:21-jre-alpine AS extractor
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# Stage 3: Runtime - using distroless for minimal image
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app

# Copy dependencies from extractor stage (minimal layers)
COPY --from=extractor /app/dependencies/ ./
COPY --from=extractor /app/spring-boot-loader/ ./
COPY --from=extractor /app/snapshot-dependencies/ ./
COPY --from=extractor /app/application/ ./

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
