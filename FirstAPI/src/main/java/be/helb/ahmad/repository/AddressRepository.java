package be.helb.ahmad.repository;

import be.helb.ahmad.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    // Recherche et renvoie une liste d'adresses par code postal.
    List<Address> findByPostalCode(int postalCode);
}
