FROM openjdk:12

#copy form target to root
ADD target target

WORKDIR /target

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./sevicosDados-0.0.1-SNAPSHOT.war"]