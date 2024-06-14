package ag.agriconnectstatistiques.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistique {
    private double tempMoy;
    private double hygroMoy;
    private double dureeMoy;
    private double tempAct;
    private double hygroAct;
    private double dureeAct;

    public Statistique(double tempMoy, double hygroMoy, double tempAct, double hygroAct) {
        this.tempMoy = tempMoy;
        this.hygroMoy = hygroMoy;
        this.tempAct = tempAct;
        this.hygroAct = hygroAct;
    }
}


