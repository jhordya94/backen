package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.Aula;
import co.edu.udes.backend.repositories.AulaRepository;
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
public class AulaController {
    @Autowired
    private AulaRepository aulaRepository;

    public AulaController() {
    }

    @GetMapping({"/aulas"})
    public List<Aula> getAllAulas() {
        return this.aulaRepository.findAll();
    }

    @PostMapping({"/aulas"})
    public Aula createAula(@RequestBody Aula aula) {
        return (Aula)this.aulaRepository.save(aula);
    }

    @GetMapping({"/aulas/{id}"})
    public ResponseEntity<Aula> getAulaById(@PathVariable Long id) {
        Aula aula = (Aula)this.aulaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aula not exist with id :" + id));
        return ResponseEntity.ok(aula);
    }

    @PutMapping({"/aulas/{id}"})
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula aulaDetails) {
        Aula aula = (Aula)this.aulaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aula not exist with id :" + id));
        aula.setNombre(aulaDetails.getNombre());
        aula.setBloque(aulaDetails.getBloque());
        aula.setCodigo(aulaDetails.getCodigo());
        aula.setEstado(aulaDetails.isEstado());
        Aula updatedAula = (Aula)this.aulaRepository.save(aula);
        return ResponseEntity.ok(updatedAula);
    }

    @DeleteMapping({"/aulas/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteAula(@PathVariable Long id) {
        Aula aula = (Aula)this.aulaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Aula not exist with id :" + id));
        this.aulaRepository.delete(aula);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

