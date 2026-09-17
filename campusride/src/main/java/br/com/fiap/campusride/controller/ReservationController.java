package br.com.fiap.campusride.controller;

import br.com.fiap.campusride.dto.ReservationRequest;
import br.com.fiap.campusride.dto.ReservationResponse;
import br.com.fiap.campusride.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/rides/{rideId}/reservations")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse create(@PathVariable Long rideId, @Valid @RequestBody ReservationRequest request) {
        return reservationService.create(rideId, request);
    }

    @PatchMapping("/reservations/{id}/cancel")
    public ReservationResponse cancel(@PathVariable Long id) {
        return reservationService.cancel(id);
    }
}