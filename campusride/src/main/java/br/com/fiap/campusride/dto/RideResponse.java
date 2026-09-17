package br.com.fiap.campusride.dto;

import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.entity.RideSituation;
import br.com.fiap.campusride.entity.VehicleType;

import java.time.LocalDateTime;

public record RideResponse(
        Long id,
        Long driverId,
        String origin,
        String destiny,
        LocalDateTime departureTime,
        Integer totalSeats,
        VehicleType vehicleType,
        RideSituation status
) {

    public static RideResponse fromEntity(Ride ride) {
        return new RideResponse(
                ride.getId(),
                ride.getDriverId(),
                ride.getOrigin(),
                ride.getDestiny(),
                ride.getDepartureTime(),
                ride.getTotalSeats(),
                ride.getVehicleType(),
                ride.getStatus()
        );
    }
}