package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import co.edu.udes.backend.models.Pensum;
import co.edu.udes.backend.repositories.PensumRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping({"/api/v1/"})
public class PensumController {
    @Autowired
    private PensumRepository pensumRepository;

    public PensumController() {
    }

    @GetMapping({"/pensums"})
    public List<Pensum> getAllPensums() {
        return this.pensumRepository.findAll();
    }

    @PostMapping({"/pensums"})
    public Pensum createPensum(@RequestBody Pensum pensum) {
        return (Pensum)this.pensumRepository.save(pensum);
    }

    @GetMapping({"/pensums/{id}"})
    public ResponseEntity<Pensum> getPensumById(@PathVariable Long id) {
        Pensum pensum = (Pensum)this.pensumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pensum not exist with id :" + id));
        return ResponseEntity.ok(pensum);
    }

    @PutMapping({"/pensums/{id}"})
    public ResponseEntity<Pensum> updatePensum(@PathVariable Long id, @RequestBody Pensum pensumDetails) {
        Pensum pensum = (Pensum)this.pensumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pensum not exist with id :" + id));
        pensum.setCodigoPensum(pensumDetails.getCodigoPensum());
        pensum.setAsignaturas(pensumDetails.getAsignaturas());
        pensum.setProgramaAcademico(pensumDetails.getProgramaAcademico());
        pensum.setEstado(pensumDetails.isEstado());
        Pensum updatedPensum = (Pensum)this.pensumRepository.save(pensum);
        return ResponseEntity.ok(updatedPensum);
    }

    @DeleteMapping({"/pensums/{id}"})
    public ResponseEntity<Map<String, Boolean>> deletePensum(@PathVariable Long id) {
        Pensum pensum = (Pensum)this.pensumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pensum not exist with id :" + id));
        this.pensumRepository.delete(pensum);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

