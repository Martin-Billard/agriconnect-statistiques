package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Capteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "accapteurs")
public interface ClientCapteur {
    @RequestMapping(value = "/api/capteurs/idUtilisateur/{id}", method = RequestMethod.GET)
    List<Capteur> findByUserId(@PathVariable("id") Long id);

}
