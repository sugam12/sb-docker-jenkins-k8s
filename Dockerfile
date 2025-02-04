FROM openjdk:17-jdk-alpine AS build
EXPOSE 8183
ADD target/department.jar department.jar
ENTRYPOINT ["java","-jar","department.jar"]