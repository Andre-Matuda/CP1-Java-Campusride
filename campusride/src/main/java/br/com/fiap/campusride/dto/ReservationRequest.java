package br.com.fiap.campusride.dto;

import jakarta.validation.constraints.NotNull;

public record ReservationRequest(
        @NotNull(message = "O passageiro é obrigatório")
        Long passengerId
) {
}
