# LIS API

Laboratory Information System service that receives patients from the Hospital API and manages laboratory tests and results.

## Run

The service runs on `http://localhost:8082` and connects to MySQL at `localhost:8889/lis_db`.

```zsh
MYSQL_PASSWORD=your_mysql_password ./mvnw spring-boot:run
```

Create the database first if it does not exist:

```sql
CREATE DATABASE lis_db;
```

## Swagger UI

After the application starts, open [Swagger UI](http://localhost:8082/swagger-ui.html) to view and send requests. The OpenAPI JSON document is available at `http://localhost:8082/v3/api-docs`.

## Endpoints

### Receive a patient from Hospital API

`POST /api/v1/patients`

```bash
curl -X POST http://localhost:8082/api/v1/patients \
  -H 'Content-Type: application/json' \
  -d '{
    "hospitalPatientId": 1,
    "name": "Sok Dara",
    "gender": "Male",
    "dateOfBirth": "1998-05-17",
    "phone": "+855-12-345-678"
  }'
```

`hospitalPatientId` and `name` are required. Sending the same `hospitalPatientId` again updates the stored LIS patient.

### Create a laboratory test

`POST /api/v1/laboratory-tests`

```bash
curl -X POST http://localhost:8082/api/v1/laboratory-tests \
  -H 'Content-Type: application/json' \
  -d '{
    "patientId": 1,
    "name": "Complete Blood Count"
  }'
```

### Record a laboratory result

`POST /api/v1/laboratory-results`

```bash
curl -X POST http://localhost:8082/api/v1/laboratory-results \
  -H 'Content-Type: application/json' \
  -d '{
    "laboratoryTestId": 1,
    "resultValue": "5.2",
    "unit": "mmol/L",
    "referenceRange": "3.9-5.5",
    "reportedAt": "2026-11-19T10:30:00"
  }'
```

`reportedAt` is optional; the API uses the current time when it is omitted.

### Retrieve and delete data

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/v1/patients` | List active patients |
| `GET` | `/api/v1/patients/{id}` | Get an active patient |
| `DELETE` | `/api/v1/patients/{id}` | Soft-delete a patient |
| `GET` | `/api/v1/laboratory-tests` | List active laboratory tests |
| `DELETE` | `/api/v1/laboratory-tests/{id}` | Soft-delete a laboratory test |
| `GET` | `/api/v1/laboratory-results` | List active laboratory results |
