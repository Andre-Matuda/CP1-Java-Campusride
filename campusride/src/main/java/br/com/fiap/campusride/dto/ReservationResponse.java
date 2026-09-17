package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.Reservation;
import br.com.fiap.campusride.entity.RideReservation;

import java.time.LocalDateTime;

public record ReservationResponse(
        Long id,
        Long rideId,
        Long passengerId,
        LocalDateTime createdAt,
        RideReservation status
) {
    public static ReservationResponse fromEntity(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(),
                reservation.getRide() != null ? reservation.getRide().getId() : null,
                reservation.getPassengerId(),
                reservation.getCreatedAt(),
                reservation.getStatus()
        );
    }
}