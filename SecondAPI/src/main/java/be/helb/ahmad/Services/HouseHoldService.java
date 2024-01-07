package be.helb.ahmad.Services;

import be.helb.ahmad.Models.HouseHoldComposition;
import be.helb.ahmad.repository.HouseHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseHoldService {

    private final HouseHoldRepository houseHoldRepository;

    @Autowired
    public HouseHoldService(HouseHoldRepository houseHoldRepository) {
        this.houseHoldRepository = houseHoldRepository;
    }

    public List<HouseHoldComposition> getAllHouseHoldCompositions() {
        return houseHoldRepository.findAll();
    }

    public Optional<HouseHoldComposition> getHouseHoldCompositionById(Long id) {
        return houseHoldRepository.findById(id);
    }

    public void saveHouseHoldComposition(HouseHoldComposition composition) {
        houseHoldRepository.save(composition);
    }

    public void deleteHouseHoldComposition(Long id) {
        houseHoldRepository.deleteById(id);
    }
}
