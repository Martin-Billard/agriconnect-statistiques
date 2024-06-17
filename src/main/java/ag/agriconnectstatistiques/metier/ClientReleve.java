package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Releve;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "acreleves")
public interface ClientReleve {

    @RequestMapping(value = "/api/releves/capteur/{id}/{date}", method = RequestMethod.GET)
    List<Releve> getRelevesParCapteurEtParJour(@PathVariable Long id, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
