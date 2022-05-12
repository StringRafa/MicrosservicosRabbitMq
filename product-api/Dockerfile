FROM openjdk
WORKDIR /app
COPY target/product-api-0.0.1-SNAPSHOT.jar /app/product-api.jar
ENTRYPOINT ["java", "-jar", "product-api.jar"]