package be.helb.ahmad.Controller;

import be.helb.ahmad.Models.Citizen;
import be.helb.ahmad.Services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping //Lorsque je Get avec la terminaison "/api/citizens" je reçois tous les citizens
    public List<Citizen> getAllCitizens() {
        return citizenService.getAllCitizens();
    }

    @GetMapping("/{id}") //Lorsque je Get avec la terminaison "/api/citizens" + id je reçois le citizen lié a l'id
    public ResponseEntity<Citizen> getCitizenById(@PathVariable Long id) {
        Optional<Citizen> citizen = citizenService.getCitizenById(id);
        return citizen.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping //Post le citizen à l'endpoint "/api/citizens/"
    public ResponseEntity<Void> saveCitizen(@RequestBody Citizen citizen) {
        citizenService.saveCitizen(citizen);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")//Delete le citizen selon l'id
    public ResponseEntity<Void> deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}