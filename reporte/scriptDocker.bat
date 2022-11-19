call mvnw clean install -DskipTests
call docker build -t danaxar/reporte-microservice .
call docker push danaxar/reporte-microservice