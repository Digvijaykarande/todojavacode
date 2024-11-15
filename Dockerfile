# Step 1: Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim AS build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the pom.xml and download the dependencies (this layer will be cached)
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Step 4: Copy the entire project
COPY . .

# Step 5: Package the application
RUN ./mvnw clean package -DskipTests

# Step 6: Use a smaller base image for running the application
FROM openjdk:17-jdk-slim

# Step 7: Copy the jar file from the build stage
COPY --from=build /app/target/todowithmongo-0.0.1-SNAPSHOT.jar /app/todowithmongo.jar

# Step 8: Expose the application port (optional, default is 8080)
EXPOSE 8080

# Step 9: Run the application
ENTRYPOINT ["java", "-jar", "/app/todowithmongo.jar"]
