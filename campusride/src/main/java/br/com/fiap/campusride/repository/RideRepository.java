package br.com.fiap.campusride.repository;

import br.com.fiap.campusride.entity.Ride;
import br.com.fiap.campusride.entity.RideSituation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {

    List<Ride> findByStatus(RideSituation status);
}
