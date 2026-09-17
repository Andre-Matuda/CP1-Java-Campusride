package br.com.fiap.campusride.dto;

import jakarta.validation.constraints.NotNull;

public record ReservationRequest(
        @NotNull(message = "O ID do passageiro não pode ser nulo")
        Long passengerId
) {}