FROM openjdk:17-alpine

ENV SERVER_PORT 3131

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR da sua aplicação para o contêiner
COPY target/crm-connector-0.0.1-SNAPSHOT.jar .

# Expose a porta da aplicação
EXPOSE $SERVER_PORT
# Executa a aplicação
CMD ["java", "-jar", "crm-connector-0.0.1-SNAPSHOT.jar"]