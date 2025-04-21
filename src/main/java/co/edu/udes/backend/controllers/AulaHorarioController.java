package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.AulaHorario;
import co.edu.udes.backend.repositories.AulaHorarioRepository;
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
public class AulaHorarioController {
    @Autowired
    private AulaHorarioRepository aulaHorarioRepository;

    public AulaHorarioController() {
    }

    @GetMapping({"/aulaHorarios"})
    public List<AulaHorario> getAllAulaHorarios() {
        return this.aulaHorarioRepository.findAll();
    }

    @PostMapping({"/aulaHorarios"})
    public AulaHorario createAulaHorario(@RequestBody AulaHorario aulaHorario) {
        return (AulaHorario)this.aulaHorarioRepository.save(aulaHorario);
    }

    @GetMapping({"/aulaHorarios/{id}"})
    public ResponseEntity<AulaHorario> getAulaHorarioById(@PathVariable Long id) {
        AulaHorario aulaHorario = (AulaHorario)this.aulaHorarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AulaHorario not exist with id :" + id));
        return ResponseEntity.ok(aulaHorario);
    }

    @PutMapping({"/aulaHorarios/{id}"})
    public ResponseEntity<AulaHorario> updateAulaHorario(@PathVariable Long id, @RequestBody AulaHorario aulaHorarioDetails) {
        AulaHorario aulaHorario = (AulaHorario)this.aulaHorarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AulaHorario not exist with id :" + id));
        aulaHorario.setAula(aulaHorarioDetails.getAula());
        aulaHorario.setHorario(aulaHorarioDetails.getHorario());
        aulaHorario.setEstado(aulaHorarioDetails.isEstado());
        aulaHorario.setCurso(aulaHorarioDetails.getCurso());
        AulaHorario updatedAulaHorario = (AulaHorario)this.aulaHorarioRepository.save(aulaHorario);
        return ResponseEntity.ok(updatedAulaHorario);
    }

    @DeleteMapping({"/aulaHorarios/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteAulaHorario(@PathVariable Long id) {
        AulaHorario aulaHorario = (AulaHorario)this.aulaHorarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AulaHorario not exist with id :" + id));
        this.aulaHorarioRepository.delete(aulaHorario);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

