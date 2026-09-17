package br.com.fiap.campusride.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passenger {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer rating;
}
