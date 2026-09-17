package br.com.fiap.campusride.repository;

import br.com.fiap.campusride.entity.Reservation;
import br.com.fiap.campusride.entity.RideReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    long countByRideIdAndStatus(Long rideId, RideReservation status);
}
