package be.helb.ahmad.Controller;

import be.helb.ahmad.Models.Address;
import be.helb.ahmad.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;  //cretation d'une variable addressservice

    @Autowired   //Constructeur
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping  //Lorsque je Get avec la terminaison "/api/addresses" je reçois toutes les adresses
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")   //Lorsque je Get avec la terminaison "/api/addresses/" + l'id existant dans l'api je reçois l'adresse avec l'id specifique
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        Optional<Address> address = addressService.getAddressById(id);
        return address.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping   //Post l'adresse à l'endpoint "/api/addresses/"
    public ResponseEntity<Void> saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("postalCode/{postalCode}")  //Get L'adresse mais de manière dynamique selon le codepostal si il existe
    public ResponseEntity<List<Address>> getAddressesByPostalCode(@PathVariable int postalCode) {
        List<Address> addresses = addressService.getAddressesByPostalCode(postalCode);

        if (!addresses.isEmpty()) {
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}") //Delete l'adresse selon l'id
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}