package ag.agriconnectstatistiques.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Statistique {
    private Double tempMoy;
    private Double hygroMoy;
    private Double dureeMoy;
    private Double tempAct;
    private Double hygroAct;
    private Integer nombreActivation;

    public Statistique(double tempMoy, double hygroMoy, double tempAct, double hygroAct) {
        this.tempMoy = tempMoy != 0.0 ? tempMoy : null;
        this.hygroMoy = hygroMoy != 0.0 ? hygroMoy : null;
        this.tempAct = tempAct != 0.0 ? tempAct : null;
        this.hygroAct = hygroAct != 0.0 ? hygroAct : null;
    }

    public Statistique(Integer nombreActivation, Double dureeMoy) {
        this.nombreActivation = nombreActivation != 0 ? nombreActivation : null;;
        this.dureeMoy = dureeMoy != 0.0 ? dureeMoy : null;;
    }
}


