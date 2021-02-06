FROM openjdk:12
ADD .mvn .mvn
ADD src src
ADD pom.xml pom.xml
ADD mvnw mvnw
RUN chmod a+x mvnw
RUN ./mvnw clean install
RUN rm -r src

WORKDIR /target

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./sevicosDados-0.0.1-SNAPSHOT.war"]