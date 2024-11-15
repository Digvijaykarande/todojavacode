# Step 1: Use a Maven base image to build the application
FROM maven:3.8.6-openjdk-17 AS build

# Step 2: Set the working directory
WORKDIR /app

# Step 3: Copy the pom.xml and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Step 4: Copy the entire project and build the application
COPY . .
RUN mvn clean package -DskipTests

# Step 5: Use an OpenJDK runtime image for the final application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/todoWithMongo-0.0.1-SNAPSHOT.jar /app/todoWithMongo.jar

# Expose the port (optional)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "todoWithMongo.jar"]
