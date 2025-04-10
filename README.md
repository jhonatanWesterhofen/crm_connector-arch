# 📡 CRM Connector - Integração com HubSpot

Este projeto é um conector de CRM para integração com a API do HubSpot, desenvolvido com **Java + Spring Boot**. Ele permite:

- 🔐 Autenticação com token privado
- 👤 Criação de contatos
- 🔁 Tratamento de erros 429 (Rate Limit Excedido) com Retry e Backoff exponencial
- 📥 Recebimento de eventos de Webhook da HubSpot com validação de assinatura
- 🧩 Estrutura modular com logs estruturados via SLF4J

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- SLF4J + Logback (logging)
- Jackson (para JSON)
- HubSpot CRM API (v3)

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 17+
- Maven 3.8+
- Conta HubSpot e token de acesso privado (ou OAuth se preferir)

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/crm-connector.git
   cd crm-connector

🚀 COMO SUBIR A API crm-connector COM DOCKER

📦 PRÉ-REQUISITOS
---------------------------------
✔️ Docker instalado
✔️ Docker Compose instalado
✔️ Projeto já compilado com Maven:
   ./mvnw clean package
   → Gera: target/crm-connector-0.0.1-SNAPSHOT.jar

📁 ESTRUTURA DE ARQUIVOS
---------------------------------
.
├── Dockerfile
├── docker-compose.yml
├── .env
└── target/
    └── crm-connector-0.0.1-SNAPSHOT.jar

🔐 .env (VARIÁVEIS DE AMBIENTE)
---------------------------------
Crie um arquivo `.env` na raiz do projeto com os seguintes valores:

SECRET=seuSegredoAqui
PASSWORD_DATABASE=1329
CLIENT_ID=suaClientIdAqui
CLIENT_SECRET=suaClientSecretAqui
URL_CALLBACK=http://localhost:3131/callback

🐳 DOCKER-COMPOSE.YML
---------------------------------
version: "3.3"

services:
  crm_connector_api:
    build: .
    environment:
      - DB_URL=jdbc:postgresql://localhost:5433/postgres
      - DB_USERNAME=crm
      - DB_PASSWORD=1329
      - SECRET=${SECRET}
      - PASSWORD_DATABASE=${PASSWORD_DATABASE}
      - CLIENT_ID=${CLIENT_ID}
      - CLIENT_SECRET=${CLIENT_SECRET}
      - URL_CALLBACK=${URL_CALLBACK}
    container_name: crm_connector_api
    ports:
      - "3131:3131"
    depends_on:
      - crm_connector_db
    networks:
      - crm_net

  crm_connector_db:
    image: postgres
    container_name: crm_connector_db
    restart: always
    ports:
      - "5433:5432"
    environment:
      POSTGRES_DB: crm-connector
      POSTGRES_USER: crm
      POSTGRES_PASSWORD: 1329
    networks:
      - crm_net

networks:
  crm_net:
    driver: bridge

🐋 DOCKERFILE
---------------------------------
FROM openjdk:17-alpine

ENV SERVER_PORT 3131

WORKDIR /app

COPY target/crm-connector-0.0.1-SNAPSHOT.jar .

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "crm-connector-0.0.1-SNAPSHOT.jar"]

📜 APPLICATION.PROPERTIES
---------------------------------
${SECRET}

spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
${PASSWORD_DATABASE}


https://app.hubspot.com/oauth/authorize
https://api.hubapi.com
https://api.hubapi.com
${CLIENT_ID}
${CLIENT_SECRET}
${URL_CALLBACK}


▶️ COMANDO PARA SUBIR TUDO
---------------------------------
docker-compose up --build

🌍 ACESSOS
---------------------------------
✅ API: http://localhost:3131
✅ Banco de Dados (Postgres): jdbc:postgresql://localhost:5433/postgres

⚠️ IMPORTANTE
---------------------------------
Não esqueça de definir corretamente as variáveis de ambiente. A aplicação depende delas para funcionar corretamente (principalmente os dados do HubSpot e do banco).



{
  "📘 title": "HubSpot CRM Connector API",
  "🧾 version": "1.0.1",
  "📝 description": "🔗 API para integração com o HubSpot, incluindo autenticação OAuth, criação de contatos e webhooks.",
  "🌐 basePath": "/",
  "🚀 endpoints": [
    {
      "📡 method": "POST",
      "🔗 path": "/crm/contacts",
      "📄 description": "👤 Cria um novo contato no sistema local e envia para o HubSpot.",
      "🔐 authentication": "🔐 Basic Auth",
      "📦 requestBodyExample": {
        "firstname": "Henrique",
        "lastname": "Gonzati",
        "email": "henrique@gmail.com",
        "phone": "45988774411",
        "company": "Empresa XYZ",
        "website": "empresa.com",
        "lifecyclestage": "marketingqualifiedlead"
      },
      "📬 responses": {
        "201": "✅ Contato criado com sucesso",
        "400": "⚠️ Erro de validação"
      }
    },
    {
      "📡 method": "GET",
      "🔗 path": "/crm/callback",
      "📄 description": "🔑 Endpoint chamado pelo HubSpot após autenticação para retornar o código de autorização.",
      "🔐 authentication": "🔓 Público",
      "📤 queryParams": {
        "code": "🔤 Código retornado pelo HubSpot"
      },
      "📬 responses": {
        "200": "✅ Callback processado com sucesso"
      }
    },
    {
      "📡 method": "GET",
      "🔗 path": "/crm/url",
      "📄 description": "🌐 Gera a URL para autenticação OAuth do HubSpot.",
      "🔐 authentication": "🔐 Basic Auth",
      "📬 responses": {
        "200": "🔗 URL de autenticação retornada com sucesso"
      }
    },
    {
      "📡 method": "POST",
      "🔗 path": "/webhook/hubspot/contact/creation",
      "📄 description": "📬 Recebe eventos de criação ou atualização de contatos via webhook do HubSpot.",
      "🔐 authentication": "🔓 Público",
      "📤 headers": {
        "X-HubSpot-Signature": "🔐 Assinatura (string)"
      },
      "📦 requestBodyExample": [
        {
          "objectId": 1246965,
          "propertyName": "lifecyclestage",
          "propertyValue": "subscriber",
          "changeSource": "ACADEMY",
          "eventId": 3816279340,
          "subscriptionId": 25,
          "portalId": 33,
          "appId": 1160452,
          "occurredAt": 1462216307945,
          "eventType": "contact.propertyChange",
          "attemptNumber": 0
        }
      ],
      "📬 responses": {
        "200": "✅ Eventos processados",
        "400": "⚠️ JSON malformado",
        "401": "🚫 Assinatura inválida"
      }
    }
  ],
  "🛡️ security": {
    "🔐 authentication": {
      "type": "Basic Auth",
      "username": "7cc5087d-6f2a-42e9-bfd3-a866a35b0a16",
      "password": "ffe9ba84-9cdb-494e-9eea-e572a1620918"
    },
    "🧯 csrf": false,
    "🌍 cors": {
      "allowedOrigins": "*",
      "allowedMethods": ["GET", "POST", "PUT", "DELETE", "OPTIONS"],
      "allowedHeaders": "*"
    },
    "🔓 publicEndpoints": [
      "/webhook/**",
      "/crm/callback"
    ]
  }
}