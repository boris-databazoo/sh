
## Superhero microservice

Homework stuff

### Development notes

 - Java 10 is optional, it will probably compile with JDK 8 just fine.
 - Enable lombok (Compiler / Annotation Processors > Enable annotation processing)
 - log4j-api-2.10.0 is not Java 10 compatible, so throws some error on startup.

### Running

`mvn -DskipTests=true clean tomcat7:run -P local`

