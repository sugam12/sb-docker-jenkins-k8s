FROM openjdk:17-jdk-alpine AS build
FROM openjdk:17-jdk-slim
ENTRYPOINT ["java","-jar","department.jar"]