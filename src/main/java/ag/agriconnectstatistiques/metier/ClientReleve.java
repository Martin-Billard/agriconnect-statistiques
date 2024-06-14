package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Releve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "acreleves")
public interface ClientReleve {


    @GetMapping("/api/releves/capteur/{id}/{date}")
    List<Releve> getRelevesParCapteurEtParJour(@PathVariable Long id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
