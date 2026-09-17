package br.com.fiap.campusride.validation;

import br.com.fiap.campusride.dto.RideRequest;
import br.com.fiap.campusride.entity.VehicleType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VehicleSeatsValidator implements ConstraintValidator<ValidVehicleSeats, RideRequest> {

    @Override
    public boolean isValid(RideRequest request, ConstraintValidatorContext context) {
        if (request == null || request.vehicleType() == null || request.totalSeats() == null) {
            return true;
        }
        return request.vehicleType() != VehicleType.MOTORCYCLE || request.totalSeats() <= 2;
    }
}
