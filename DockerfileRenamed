FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp
ADD /target/*.jar /opt/k8stutorial-ms.jar
EXPOSE 8080
WORKDIR /opt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dfile.encoding=UTF-8","-jar","k8stutorial-ms.jar"]
