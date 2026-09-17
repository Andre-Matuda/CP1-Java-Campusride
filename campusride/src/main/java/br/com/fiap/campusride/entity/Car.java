package br.com.fiap.campusride.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private Long id;
    private String carPlate;
    private Integer capacity;
    private String model;
    private LocalDate releaseDate;
}
