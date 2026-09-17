package br.com.fiap.campusride.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private Long id;
    private String name;
    private String cnh;
    private Integer age;
    private Integer rating;
    private String email;
}
