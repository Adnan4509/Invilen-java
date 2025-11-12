# Step 1: Build using Maven inside Docker
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

#Using openjdk 21
FROM eclipse-temurin:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy built JAR file into the container
COPY --from=builder /build/target/*.jar app.jar

# Expose the application port (change accordingly)
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
