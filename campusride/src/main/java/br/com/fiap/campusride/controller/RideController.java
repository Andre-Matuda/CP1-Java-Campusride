package br.com.fiap.campusride.controller;

import br.com.fiap.campusride.dto.RideRequest;
import br.com.fiap.campusride.dto.RideResponse;
import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.service.RideService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    public ResponseEntity<RideResponse> create(@RequestBody RideRequest request) {
        Ride ride = new Ride();
        ride.setDriverId(request.driverId()); // Recebe o Long do request perfeitamente
        ride.setOrigin(request.origin());
        ride.setDestiny(request.destiny());
        ride.setDepartureTime(request.departureTime());
        ride.setVehicleType(request.vehicleType());
        ride.setTotalSeats(request.totalSeats());

        Ride savedRide = rideService.create(ride);

        return ResponseEntity.status(HttpStatus.CREATED).body(RideResponse.fromEntity(savedRide));
    }

    @GetMapping
    public ResponseEntity<List<RideResponse>> findAll() {
        List<RideResponse> rides = rideService.findAll()
                .stream()
                .map(RideResponse::fromEntity)
                .toList();
        return ResponseEntity.ok(rides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideResponse> findById(@PathVariable Long id) {
        Ride ride = rideService.findById(id);
        return ResponseEntity.ok(RideResponse.fromEntity(ride));
    }
}