package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class StatistiquesService {

    private final ClientReleve clientReleve;
    private final ClientCapteur clientCapteur;
    private final ClientActionneur clientActionneur;
    private final ClientHistorique clientHistorique;

    public StatistiquesService(ClientReleve clientReleve, ClientCapteur clientCapteur, ClientActionneur clientActionneur, ClientHistorique clientHistorique) {
        this.clientReleve = clientReleve;
        this.clientCapteur = clientCapteur;
        this.clientActionneur = clientActionneur;
        this.clientHistorique = clientHistorique;
    }


    public HashMap<Object, Statistique> getStatistiqueIdUtilisateur(Long idUtilisateur) {
        List<Capteur> capteurList = clientCapteur.findByUserId(idUtilisateur);
        List<Actionneur> actionneurList = clientActionneur.findByUserId(idUtilisateur);
        HashMap<Object, Statistique> statistiqueIdUtilisateur = new HashMap<>();
        LocalDate date = LocalDate.now();
        return getObjectStatistiqueHashMap(date, capteurList, actionneurList,statistiqueIdUtilisateur);
    }

    public HashMap<Object, Statistique> getStatistiqueIdUtilisateurParJour(Long idUtilisateur, LocalDate date) {
        List<Capteur> capteurList = clientCapteur.findByUserId(idUtilisateur);
        List<Actionneur> actionneurList = clientActionneur.findByUserId(idUtilisateur);
        HashMap<Object, Statistique> statistiqueIdUtilisateur = new HashMap<>();
        return getObjectStatistiqueHashMap(date, capteurList, actionneurList,statistiqueIdUtilisateur);
    }


    private static double calculateMoyenneHumidite(List<Releve> releves) {
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

    private static double calculateMoyenneDuree(List<Historique> historiques) {
        return historiques.stream()
                .mapToLong(Historique::getDuree)
                .average()
                .orElse(0.0);
    }

    private HashMap<Object, Statistique> getObjectStatistiqueHashMap(LocalDate date, List<Capteur> capteurList,List<Actionneur> actionneurList ,HashMap<Object, Statistique> statistiqueIdUtilisateur) {
        for (Capteur capteur : capteurList) {
            List<Releve> releveList = clientReleve.getRelevesParCapteurEtParJour(capteur.getId(), date);
            double tempMoy = calculateMoyenneTemperature(releveList);
            double humMoy = calculateMoyenneHumidite(releveList);
            Statistique statistique = new Statistique(tempMoy, humMoy, capteur.getTemperature(), capteur.getHumidite());
            statistiqueIdUtilisateur.put(capteur, statistique);
        }
        for (Actionneur actionneur : actionneurList){
            List<Historique> historiquesList = clientHistorique.getHistoriquesByIdActionneurAndDate(actionneur.getId(), date);
            Integer nombreActivation = historiquesList.size();
            double dureeMoy = calculateMoyenneDuree(historiquesList);
            Statistique statistique = new Statistique(nombreActivation, dureeMoy);
            statistiqueIdUtilisateur.put(actionneur, statistique);
        }
        return statistiqueIdUtilisateur;
    }
}
