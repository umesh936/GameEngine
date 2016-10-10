FROM java:8
ADD target/GameEngine-0.0.1-SNAPSHOT.jar /opt/GameEngine/GameEngine-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/opt/GameEngine/GameEngine-0.0.1-SNAPSHOT.jar"]
