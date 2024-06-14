package ag.agriconnectstatistiques.controller;

import ag.agriconnectstatistiques.entities.Statistique;
import ag.agriconnectstatistiques.metier.StatistiquesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/api/statistiques")
public class StatistiquesController {

    private final StatistiquesService statistiquesService;

    public StatistiquesController(StatistiquesService statistiquesService) {
        this.statistiquesService = statistiquesService;
    }


    @GetMapping("{idUti}")
    public HashMap<Object, Statistique> getStatitique(@PathVariable Long idUti) {
        return statistiquesService.getStatistiqueIdUtilisateur(idUti);
    }


    @GetMapping("{idUti}/{date}")
    public HashMap<Object, Statistique> getStatitique(@PathVariable Long idUti, @PathVariable LocalDate date) {
        return statistiquesService.getStatistiqueIdUtilisateurParJour(idUti, date);
    }
}
