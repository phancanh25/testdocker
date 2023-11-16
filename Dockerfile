FROM maven:3.8.5-openjdk-17

WORKDIR /testdocker
COPY . .
EXPOSE 8082
RUN ["mvn", "clean", "install", "-DskipTests"]

CMD mvn spring-boot:run