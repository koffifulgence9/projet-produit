FROM eclipse-temurin:22-jdk-alpine

WORKDIR /app

COPY target/produit.jar ./produit.jar

EXPOSE 8080

CMD ["java", "-jar", "produit.jar"]
