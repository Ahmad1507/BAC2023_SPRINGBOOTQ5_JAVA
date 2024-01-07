package be.helb.ahmad.Services;

import be.helb.ahmad.Models.Document;
import be.helb.ahmad.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;  // Référence au repository permettant d'interagir avec la base de données.

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    // Récupère tous les documents présents dans la base de données.
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    // Récupère un document par son ID.
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    // Enregistre un nouveau document dans la base de données.
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    // Supprime un document de la base de données par son ID.
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
