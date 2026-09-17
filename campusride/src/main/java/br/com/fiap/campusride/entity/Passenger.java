package br.com.fiap.campusride.entity;

import lombok.*;

@Data
@Getter
@Setter
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
