package be.helb.ahmad.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private int postalCode;

    public Address(String street, String city, int postalCode) { //Constructeur Address
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }
    
    @ManyToOne  // Il peut y'avoir plusieur adresse pour un meme citizen
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

}