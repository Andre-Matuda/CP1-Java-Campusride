package br.com.fiap.campusride.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motorcycle {
    private Long id;
    private String motorPlate;
    private Integer capacity;
    private String model;
    private LocalDate releaseDate;
}
