FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

RUN mv target/*.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","app.jar"]