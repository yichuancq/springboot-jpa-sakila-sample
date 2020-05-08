package com.example.repostiory;
import com.example.domain.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
