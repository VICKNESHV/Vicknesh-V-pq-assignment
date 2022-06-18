From openjdk:11
copy ./build/libs/stocks-service-0.0.1-SNAPSHOT.jar stocks-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","stocks-service-0.0.1-SNAPSHOT.jar"]