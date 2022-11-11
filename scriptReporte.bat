cd "C:\Users\danie\OneDrive\Escritorio\Técnicas de ingeniería de software\Evaluaciones\Evaluación 2\mtisw2_reporte"
git add *
git commit -m "avance"
git push
mvnw clean install -DskipTests
docker build -t danaxar/reporte-microservice .
docker push danaxar/reporte-microservice