# CampusRide

API REST para publicar caronas e reservar vagas.

## Como executar

É necessário ter Java configurado na máquina. No terminal, dentro da pasta do projeto:

```powershell
.\mvnw.cmd spring-boot:run
```

A API inicia em `http://localhost:8080`. O console do H2 fica em
`http://localhost:8080/h2-console`.

## Endpoints

| Método | URL | Descrição |
| --- | --- | --- |
| POST | `/rides` | Publica uma carona |
| GET | `/rides` | Lista caronas abertas |
| GET | `/rides/{id}` | Mostra a carona e suas reservas |
| PATCH | `/rides/{id}/cancel` | Cancela uma carona e suas reservas |
| POST | `/rides/{rideId}/reservations` | Reserva uma vaga |
| PATCH | `/reservations/{id}/cancel` | Cancela uma reserva |

## Exemplos

Criar uma carona:

```json
POST /rides
{
  "driverId": 1,
  "origin": "FIAP Paulista",
  "destiny": "Metro Trianon-Masp",
  "departureTime": "2026-12-01T18:00:00",
  "vehicleType": "CAR",
  "totalSeats": 4
}
```

Reservar uma vaga na carona 1:

```json
POST /rides/1/reservations
{
  "passengerId": 2
}
```
