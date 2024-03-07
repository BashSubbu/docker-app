FROM  ubuntu:20.04 as build-stage
RUN apt-get update -y
RUN apt-get install -y openjdk-11-jdk-headless maven mysql-client
WORKDIR /opt
ADD pom.xml /opt
RUN mvn -f pom.xml dependency:resolve
ADD . /opt
RUN mvn -f pom.xml clean install spring-boot:repackage

FROM ubuntu:20.04 as production-stage
RUN apt-get update -y --fix-missing
RUN apt-get install -y openjdk-11-jdk-headless mysql-client
WORKDIR /opt
COPY --from=build-stage /opt/target/spring-docker.jar /opt/
EXPOSE 8079
CMD [ "java", "-Dspring.profiles.active=default", "-jar", "spring-docker.jar" ]
