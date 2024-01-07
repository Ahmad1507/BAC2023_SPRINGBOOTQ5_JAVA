package be.helb.ahmad.Controller;

import be.helb.ahmad.Models.HouseHoldComposition;
import be.helb.ahmad.Services.HouseHoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/households")
public class HouseHoldController {

    private final HouseHoldService houseHoldService;

    @Autowired
    public HouseHoldController(HouseHoldService houseHoldService) {
        this.houseHoldService = houseHoldService;
    }

    @GetMapping
    public List<HouseHoldComposition> getAllHouseHoldCompositions() {
        return houseHoldService.getAllHouseHoldCompositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HouseHoldComposition> getHouseHoldCompositionById(@PathVariable Long id) {
        Optional<HouseHoldComposition> composition = houseHoldService.getHouseHoldCompositionById(id);
        return composition.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Void> saveHouseHoldComposition(@RequestBody HouseHoldComposition composition) {
        houseHoldService.saveHouseHoldComposition(composition);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouseHoldComposition(@PathVariable Long id) {
        houseHoldService.deleteHouseHoldComposition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
