package ag.agriconnectstatistiques.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Historique {
    private Long id;

    private Long idActionneur;

    private LocalDate date;

    private  Long duree;
}
