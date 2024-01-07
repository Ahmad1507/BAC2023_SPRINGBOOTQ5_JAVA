package be.helb.ahmad.Services;

import be.helb.ahmad.Models.Address;
import be.helb.ahmad.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;  // Référence au repository permettant d'interagir avec la base de données.

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Récupère toutes les adresses présentes dans la base de données.
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    // Récupère une adresse par son ID.
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Enregistre une nouvelle adresse dans la base de données.
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    // Récupère des adresses par leur code postal.
    public List<Address> getAddressesByPostalCode(int postalCode) {
        return addressRepository.findByPostalCode(postalCode);
    }

    // Supprime une adresse de la base de données par son ID.
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
