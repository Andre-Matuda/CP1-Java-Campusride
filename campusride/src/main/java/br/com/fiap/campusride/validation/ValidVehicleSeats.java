package br.com.fiap.campusride.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VehicleSeatsValidator.class)
public @interface ValidVehicleSeats {

    String message() default "Motocicletas podem oferecer no máximo 2 vagas";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
