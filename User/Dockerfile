FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Install dos2unix to convert the line endings to unix format
RUN apk add --no-cache dos2unix
# Make the mvnw script executable
RUN dos2unix mvnw

# make the mvnw script executable
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline
 
COPY src ./src

EXPOSE 5011
CMD ./mvnw spring-boot:run
