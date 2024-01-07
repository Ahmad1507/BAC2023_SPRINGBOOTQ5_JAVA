package be.helb.ahmad.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    public Citizen (String firstName, String lastName, String email) {  //Constructeur citizen
        this.firstName = firstName;
        this.lastName= lastName;
        this.email = email;
    }
    @JsonIgnore  // Ignorer la sérialisation de cette propriété (POST la meme info de manière infini)
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)  // un citizen peut etre lié à plusieurs adresses
    private List<Address> addresses;



    @JsonIgnore  // Ignorer la sérialisation de cette propriété (POST la meme info de manière infini)
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL) // un citizen peut etre lié à plusieurs documents
    private List<Document> documents;


    @JsonIgnore  // Ignorer la sérialisation de cette propriété car bug boucle infini (POST la meme info de manière infini)
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL) // un citizen peut etre lié à plusieurs events
    private List<Event> events;
}