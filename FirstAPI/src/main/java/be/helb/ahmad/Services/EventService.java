package be.helb.ahmad.Services;

import be.helb.ahmad.Models.Event;
import be.helb.ahmad.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;  // Référence au repository permettant d'interagir avec la base de données.

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Récupère tous les événements présents dans la base de données.
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Récupère un événement par son ID.
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Enregistre un nouveau événement dans la base de données.
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    // Supprime un événement de la base de données par son ID.
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
