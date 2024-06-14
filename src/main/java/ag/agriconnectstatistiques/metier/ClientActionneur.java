package ag.agriconnectstatistiques.metier;

import ag.agriconnectstatistiques.entities.Actionneur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "acactionneurs")
public interface ClientActionneur {

    @GetMapping("/api/actionneurs/idUtilisateur/{id}")
    List<Actionneur> findByUserId(@PathVariable("id") Long id);
}
