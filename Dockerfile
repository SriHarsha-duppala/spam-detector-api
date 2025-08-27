# Use Java 17
FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copy source code
COPY src src

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

# Copy the built jar
COPY target/spamdetector-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
