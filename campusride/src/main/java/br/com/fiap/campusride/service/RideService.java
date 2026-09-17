package br.com.fiap.campusride.service;

import br.com.fiap.campusride.entity.Reservation;
import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.entity.RideReservation;
import br.com.fiap.campusride.entity.RideSituation;
import br.com.fiap.campusride.repository.RideRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride create(Ride ride) {
        if (ride.getStatus() == null) {
            ride.setStatus(RideSituation.PROGRESS);
        }
        return rideRepository.save(ride);
    }

    public List<Ride> findAll() {
        return rideRepository.findAll();
    }

    public Ride findById(Long id) {
        return rideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carona não encontrada"));
    }

    @Transactional
    public Ride cancel(Long id) {
        Ride ride = findById(id);

        if (ride.getStatus() == RideSituation.CONCLUDED) {
            throw new RuntimeException("Uma carona concluída não pode ser cancelada");
        }

        ride.setStatus(RideSituation.CANCELED);

        for (Reservation reservation : ride.getReservations()) {
            reservation.setStatus(RideReservation.CANCELED);
        }

        return rideRepository.save(ride);
    }

    @Transactional
    public Reservation reserveRide(Long rideId) {
        Ride ride = findById(rideId);

        if (ride.getStatus() != RideSituation.OPEN) {
            throw new RuntimeException("Esta carona não está aceitando reservas no momento.");
        }

        if (ride.getReservations().size() >= ride.getTotalSeats()) {
            throw new RuntimeException("Não há vagas disponíveis nesta carona.");
        }

        Reservation reservation = new Reservation();
        reservation.setRide(ride);
        reservation.setStatus(RideReservation.CONFIRMED);

        ride.getReservations().add(reservation);
        rideRepository.save(ride);

        return reservation;
    }
}