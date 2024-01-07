package be.helb.ahmad.repository;

import be.helb.ahmad.Models.HouseHoldComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseHoldRepository extends JpaRepository<HouseHoldComposition, Long> {
}
