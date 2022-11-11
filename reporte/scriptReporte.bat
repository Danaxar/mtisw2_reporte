git add *
git commit -m "avance"
git push
mvnw clean install -DskipTests
./docker build -t danaxar/reporte-microservice .
./docker push danaxar/reporte-microservice