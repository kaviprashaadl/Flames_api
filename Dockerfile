FROM eclipse-temurin:17
RUN mkdir /opt/app
COPY target/FlamesApp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
