package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.VehicleType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RideRequest(
        @NotNull(message = "O ID do motorista não pode ser nulo")
        Long driverId, // <-- Garanta que é Long maiúsculo

        @NotBlank(message = "A origem não pode estar em branco")
        String origin,

        @NotBlank(message = "O destino não pode estar em branco")
        String destiny,

        @NotNull(message = "A data de partida é obrigatória")
        @Future(message = "A data de partida deve ser no futuro")
        LocalDateTime departureTime,

        @NotNull(message = "O tipo de veículo é obrigatório")
        VehicleType vehicleType,

        @NotNull(message = "O total de assentos é obrigatório")
        @Min(value = 1, message = "Deve haver pelo menos 1 assento")
        Integer totalSeats
) {

}