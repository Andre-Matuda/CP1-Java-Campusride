package br.com.fiap.campusride.entity;

import br.com.fiap.campusride.entity.RideSituation;
import br.com.fiap.campusride.entity.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long driverId;
    private String origin;
    private String destiny;
    private LocalDateTime departureTime;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Integer totalSeats;

    @Enumerated(EnumType.STRING)
    private RideSituation status = RideSituation.OPEN;
}