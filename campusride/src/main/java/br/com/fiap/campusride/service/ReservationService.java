package br.com.fiap.campusride.service;

import br.com.fiap.campusride.dto.ReservationRequest;
import br.com.fiap.campusride.dto.ReservationResponse;
import br.com.fiap.campusride.entity.Reservation;
import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.entity.RideReservation;
import br.com.fiap.campusride.entity.RideSituation;
import br.com.fiap.campusride.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RideService rideService;

    @Transactional
    public ReservationResponse create(Long rideId, ReservationRequest request) {
        Ride ride = rideService.findById(rideId);
        if (ride.getStatus() != RideSituation.OPEN) {
            throw new IllegalStateException("Esta carona não está aberta para reservas");
        }

        long confirmedReservations =
                reservationRepository.countByRideIdAndStatus(
                        rideId,
                        RideReservation.CONFIRMED
                );
        if (confirmedReservations >= ride.getTotalSeats()) {
            ride.setStatus(RideSituation.FULL);
            throw new IllegalStateException("Não há vagas disponíveis nesta carona");
        }

        Reservation reservation = Reservation.builder()
                .ride(ride)
                .passengerId(request.passengerId())
                .status(RideReservation.CONFIRMED)
                .build();
        Reservation savedReservation = reservationRepository.save(reservation);

        if (confirmedReservations + 1 == ride.getTotalSeats()) {
            ride.setStatus(RideSituation.FULL);
        }
        return toResponse(savedReservation);
    }

    @Transactional
    public ReservationResponse cancel(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        if (reservation.getStatus() == RideReservation.CANCELED) {
            throw new IllegalStateException("Esta reserva já foi cancelada");
        }
        if (reservation.getRide().getStatus() == RideSituation.CONCLUDED) {
            throw new IllegalStateException("Não é possível cancelar uma reserva de carona concluída");
        }

        reservation.setStatus(RideReservation.CANCELED);
        if (reservation.getRide().getStatus() == RideSituation.FULL) {
            reservation.getRide().setStatus(RideSituation.OPEN);
        }
        return toResponse(reservation);
    }

    private ReservationResponse toResponse(Reservation reservation) {
        return new ReservationResponse(
                reservation.getId(), reservation.getRide().getId(), reservation.getPassengerId(),
                reservation.getCreatedAt(), reservation.getStatus()
        );
    }
}
