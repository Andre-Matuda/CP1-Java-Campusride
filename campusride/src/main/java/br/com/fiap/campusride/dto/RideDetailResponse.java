package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.RideSituation;
import br.com.fiap.campusride.entity.VehicleType;

import java.time.LocalDateTime;
import java.util.List;

public record RideDetailResponse(
        Long id,
        Long driverId,
        String origin,
        String destiny,
        LocalDateTime departureTime,
        VehicleType vehicleType,
        Integer totalSeats,
        Integer availableSeats,
        RideSituation status,
        List<ReservationResponse> reservations
) {
}
