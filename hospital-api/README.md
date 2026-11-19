# Hospital API

Spring Boot REST API for managing patients and receiving healthcare payloads.

## Run

```zsh
./mvnw spring-boot:run
```

The API runs at `http://localhost:8081`.

## Swagger UI

After starting the application, open [Swagger UI](http://localhost:8081/swagger-ui.html). The OpenAPI JSON document is available at `http://localhost:8081/v3/api-docs`.

## Create a patient

`POST /api/v1/patients`

```bash
curl -X POST http://localhost:8081/api/v1/patients \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Sok Dara",
    "gender": "Male",
    "dateOfBirth": "1998-05-17",
    "phone": "+855-12-345-678"
  }'
```

`name` is required. `dateOfBirth`, when provided, must be a past date in `YYYY-MM-DD` format.

## Receive a healthcare payload

`POST /api/v1/healthcare/receive`

```bash
curl -X POST http://localhost:8081/api/v1/healthcare/receive \
  -H 'Content-Type: application/json' \
  -d '{
    "patient": {
      "code": "PAT-001",
      "name": "Sok Dara",
      "gender": "Male",
      "dateOfBirth": "1998-05-17"
    },
    "requestId": "REQ-001"
  }'
```

The `patient` object and its non-empty `code` field are required. Other JSON fields are stored as received.
