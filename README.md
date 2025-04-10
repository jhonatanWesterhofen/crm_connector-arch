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
