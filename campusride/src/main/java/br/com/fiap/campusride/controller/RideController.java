package br.com.fiap.campusride.controller;

import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.service.RideService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Ride create(@RequestBody Ride ride) {
        return rideService.create(ride);
    }

    @GetMapping
    public List<Ride> findAll() {
        return rideService.findAll();
    }
}