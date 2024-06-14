package ag.agriconnectstatistiques.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

// Utilisation de lombok pour générer constructeurs, getters...
// on veut le constrcteur avec TOUS les attributs
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

public class Capteur implements Serializable {

    private Long id;

    private float longitude;

    private float latitude;

    private double temperature;

    private int humidite;

    private int intervalle;

    private Long idUtilisateur;

    @Override
    public String toString() {
        return "Capteur{id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", intervalle=" + intervalle +'}';
    }
}
