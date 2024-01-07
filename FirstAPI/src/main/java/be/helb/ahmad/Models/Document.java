package be.helb.ahmad.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType;
    private String documentNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")  //Format de la date
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = "citizen_id") //Plusieurs documents lié à un citizen
    private Citizen citizen;

}