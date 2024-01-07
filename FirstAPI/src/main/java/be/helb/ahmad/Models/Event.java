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
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    @JsonFormat(pattern = "yyyy-MM-dd")  // Format de la date
    private Date eventDate;

    private String location;


    @ManyToOne  // Plusieurs event lié à un ciizen
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

}