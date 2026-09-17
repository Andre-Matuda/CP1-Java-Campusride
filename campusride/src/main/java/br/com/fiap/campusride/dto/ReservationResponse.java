package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.RideReservation;

import java.time.LocalDateTime;

public record ReservationResponse(
        Long id,
        Long rideId,
        Long passengerId,
        LocalDateTime createdAt,
        RideReservation status
) {
}
