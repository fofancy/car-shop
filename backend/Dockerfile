FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD /build/libs/carshop-0.5.jar carshop-0.5.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/carshop-0.5.jar"]