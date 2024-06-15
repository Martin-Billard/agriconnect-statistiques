package ag.agriconnectstatistiques.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
// on veut le constrcteur SANS argument
@NoArgsConstructor
// on veut les setters pour TOUS les attributs
@Setter
// on veut les getters pour TOUS les attributs
@Getter
/**
 * Objet Client TRANSIENT (utilisé pour la communication uniquement) embarquant une liste de comptes
 */
public class Actionneur implements Serializable {

    private Long id;

    private String etat;

    private double longitude;

    private double latitude;

    @Override
    public String toString() {
        return "Actionneur{id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", etat=" + etat +'}';
    }
}
