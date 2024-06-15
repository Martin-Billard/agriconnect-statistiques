package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Historique;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@FeignClient("achistoriques")
public interface ClientHistorique {

    @GetMapping("/api/historiques/actionneur/{idActionneur}/date/{date}")
    public List<Historique> getHistoriquesByIdActionneurAndDate(@PathVariable Long idActionneur, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
