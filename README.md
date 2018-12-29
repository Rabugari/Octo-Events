# Octo Events

Octo Events  uma aplicação que recebe eventos do Github Events via webhooks e os expõe via API para uso futuro.

###Tecnologias/Frameworks utilizados:
        * Kotlin
        * Spring Boot
        * ngrok
        * JUnit
        * Mockito
        * Gson

##Para executar
    - Necessário instalar ngrok (https://ngrok.com/), e roda-lo na porta: 9091 (sudo ngrok http 9091)
    - Necessário depedência com banco Postgre (Banco-local)
        Configurações de banco de dados:
            -url:postgres
            -username:postgres
            -password:admin

##Endpoints:
### 1. Endpoint Webhook
O endpoint deve ser disponibilizado em `/events`

### 2. Endpoint Events

**Request:**

> GET /issues/1000/events

**Response:**

> 200 OK
```javascript
[ 
  { "action": "open", created_at: "...",}, 
  { "action": "closed", created_at: "...",} 
]

## Exemplo de uso:

Aqui um link para exemplo de uso: https://developer.github.com/webhooks/testing/