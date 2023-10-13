FROM openjdk:11
EXPOSE 8080
ADD demo-1/target/demo-docker.jar demo-1/demo-docker.jar
ENTRYPOINT ["java","-jar","/demo-docker.jar"]