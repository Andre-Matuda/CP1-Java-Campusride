package br.com.fiap.campusride.entity;

import br.com.fiap.campusride.entity.RideReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RideReservation status = RideReservation.CANCELED;

    private Ride ride;

    private Passenger passenger;

    private LocalDateTime createdAt;

}
