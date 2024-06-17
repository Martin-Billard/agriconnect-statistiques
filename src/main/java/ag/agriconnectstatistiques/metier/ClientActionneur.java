package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Actionneur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "acactionneurs")
public interface ClientActionneur {

    @RequestMapping(value = "/api/actionneurs/idUtilisateur/{id}", method = RequestMethod.GET)
    List<Actionneur> findByUserId(@PathVariable("id") Long id);
}
