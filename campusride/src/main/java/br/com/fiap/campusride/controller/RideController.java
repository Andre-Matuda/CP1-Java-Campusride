package br.com.fiap.campusride.controller;

import br.com.fiap.campusride.dto.RideRequest;
import br.com.fiap.campusride.dto.RideResponse;
import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.service.RideService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
@CrossOrigin(origins = "*")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping
    public List<RideResponse> findAll() {
        return rideService.findAll()
                .stream()
                .map(RideResponse::fromEntity)
                .toList();
    }

    @PostMapping
    public Ride create(@RequestBody @Valid RideRequest rideRequest){
        return rideService.create(rideRequest.toEntity());
    }
}
