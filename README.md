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
