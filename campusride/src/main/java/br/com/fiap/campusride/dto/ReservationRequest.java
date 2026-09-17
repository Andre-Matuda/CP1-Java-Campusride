package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.VehicleType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservationRequest(
        @NotNull
        Long driverId,

        @NotNull
        Long passengerId,

        @NotBlank
        String origin,

        @NotBlank
        String destiny,

        @NotNull
        @Future
        LocalDateTime departureTime,

        @NotNull
        VehicleType vehicleType,

        @NotNull
        @Min(1)
        Integer totalSeats


) {
}
