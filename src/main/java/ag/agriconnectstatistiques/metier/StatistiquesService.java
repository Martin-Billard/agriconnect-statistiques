package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Capteur;
import ag.agriconnectstatistiques.entities.Releve;
import ag.agriconnectstatistiques.entities.Statistique;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class StatistiquesService {

    private final ClientReleve clientReleve;
    private final ClientCapteur clientCapteur;
    private final ClientActionneur clientActionneur;

    public StatistiquesService(ClientReleve clientReleve, ClientCapteur clientCapteur, ClientActionneur clientActionneur) {
        this.clientReleve = clientReleve;
        this.clientCapteur = clientCapteur;
        this.clientActionneur = clientActionneur;
    }


    public HashMap<Object, Statistique> getStatistiqueIdUtilisateur(Long idUtilisateur) {
        List<Capteur> capteurList = clientCapteur.findByUserId(idUtilisateur);
        HashMap<Object, Statistique> statistiqueIdUtilisateur = new HashMap<>();
        LocalDate date = LocalDate.now();
        return getObjectStatistiqueHashMap(idUtilisateur, date, capteurList, statistiqueIdUtilisateur);
    }

    public HashMap<Object, Statistique> getStatistiqueIdUtilisateurParJour(Long idUtilisateur, LocalDate date) {
        List<Capteur> capteurList = clientCapteur.findByUserId(idUtilisateur);
        HashMap<Object, Statistique> statistiqueIdUtilisateur = new HashMap<>();
        return getObjectStatistiqueHashMap(idUtilisateur, date, capteurList, statistiqueIdUtilisateur);
    }


    private static double calculateMoyenneHumidity(List<Releve> releves) {
        return releves.stream()
                .mapToInt(Releve::getHumitide)
                .average()
                .orElse(0.0);
    }

    private static double calculateMoyenneTemperature(List<Releve> releves) {
        return releves.stream()
                .mapToDouble(Releve::getTemperature)
                .average()
                .orElse(0.0);
    }

    private HashMap<Object, Statistique> getObjectStatistiqueHashMap(Long idUtilisateur, LocalDate date, List<Capteur> capteurList, HashMap<Object, Statistique> statistiqueIdUtilisateur) {
        for (Capteur capteur : capteurList) {
            List<Releve> releveList = clientReleve.getRelevesParCapteurEtParJour(idUtilisateur, date);
            double tempMoy = calculateMoyenneTemperature(releveList);
            double humMoy = calculateMoyenneHumidity(releveList);
            Statistique statistique = new Statistique(tempMoy, humMoy, capteur.getTemperature(), capteur.getHumidite());
            statistiqueIdUtilisateur.put(capteur, statistique);
        }
        return statistiqueIdUtilisateur;
    }
}
