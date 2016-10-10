FROM maven:3.3-jdk-8-onbuild
ADD target/GameEngine-0.0.1-SNAPSHOT.jar /opt/GameEngine/GameEngine-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/opt/GameEngine/GameEngine-0.0.1-SNAPSHOT.jar"]
