package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Capteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "accapteurs")
public interface ClientCapteur {
    @GetMapping("/api/capteurs/idUtilisateur/{id}")
    List<Capteur> findByUserId(@PathVariable("id") Long id);

}
