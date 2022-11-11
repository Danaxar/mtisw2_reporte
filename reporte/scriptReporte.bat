git add *
git commit -m "avance"
git push
mvnw clean install -DskipTests
call docker build -t danaxar/reporte-microservice .
call docker push danaxar/reporte-microservice