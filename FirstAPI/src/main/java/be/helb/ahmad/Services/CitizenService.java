package be.helb.ahmad.Services;

import be.helb.ahmad.Models.Citizen;
import be.helb.ahmad.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenService {

    private final CitizenRepository citizenRepository;  // Référence au repository permettant d'interagir avec la base de données.

    @Autowired
    public CitizenService(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    // Récupère tous les citoyens présents dans la base de données.
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll();
    }

    // Récupère un citoyen par son ID.
    public Optional<Citizen> getCitizenById(Long id) {
        return citizenRepository.findById(id);
    }

    // Enregistre un nouveau citoyen dans la base de données.
    public void saveCitizen(Citizen citizen) {
        citizenRepository.save(citizen);
    }

    // Supprime un citoyen de la base de données par son ID.
    public void deleteCitizen(Long id) {
        citizenRepository.deleteById(id);
    }
}
