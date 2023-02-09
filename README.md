# bank-spring-boot-test

Pasos para desplegar api:

1. Ingresar en la carpeta llamada "Sofka-docker"
2. Abrir la terminar en la carpeta.
3. Ejecutar el comando "docker build -t sofka-prueba ." para construir la imagen.
4. Posteriormente ejecutar el comando "docker compose up -d" para correr la receta donde ya está configurado el postgres y el api.
5. Ingresar al url "http://localhost:8082/swagger-ui/index.html#/" para verificar el swagger del api corriendo correctamente.

Colección de POSTMAN para ejecutar los endpoints requeridos:
https://api.postman.com/collections/4369576-75e9e3fd-87b1-4a7a-a285-776d0a303368?access_key=PMAT-01GRTETHBFQF23PN9B67Z96SR3
