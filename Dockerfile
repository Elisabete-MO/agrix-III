# Primeiro estágio: construção do pacote da aplicação
FROM maven:3-openjdk-17 as build-image

WORKDIR /to-build-app

COPY pom.xml .
COPY src ./src

RUN mvn dependency:go-offline

RUN mvn package -DskipTests

# Segundo estágio: construção da imagem final
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build-image /to-build-app/target/*.jar ./agrix.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "agrix.jar"]
