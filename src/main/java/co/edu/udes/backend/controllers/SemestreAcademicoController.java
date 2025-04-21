package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.SemestreAcademico;
import co.edu.udes.backend.repositories.SemestreAcademicoRepository;
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
public class SemestreAcademicoController {
    @Autowired
    private SemestreAcademicoRepository semestreAcademicoRepository;

    public SemestreAcademicoController() {
    }

    @GetMapping({"/semestreAcademicos"})
    public List<SemestreAcademico> getAllSemestreAcademicos() {
        return this.semestreAcademicoRepository.findAll();
    }

    @PostMapping({"/semestreAcademicos"})
    public SemestreAcademico createSemestreAcademico(@RequestBody SemestreAcademico semestreAcademico) {
        return (SemestreAcademico)this.semestreAcademicoRepository.save(semestreAcademico);
    }

    @GetMapping({"/semestreAcademicos/{id}"})
    public ResponseEntity<SemestreAcademico> getSemestreAcademicoById(@PathVariable Long id) {
        SemestreAcademico semestreAcademico = (SemestreAcademico)this.semestreAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SemestreAcademico not exist with id :" + id));
        return ResponseEntity.ok(semestreAcademico);
    }

    @PutMapping({"/semestreAcademicos/{id}"})
    public ResponseEntity<SemestreAcademico> updateSemestreAcademico(@PathVariable Long id, @RequestBody SemestreAcademico semestreAcademicoDetails) {
        SemestreAcademico semestreAcademico = (SemestreAcademico)this.semestreAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SemestreAcademico not exist with id :" + id));
        semestreAcademico.setYear(semestreAcademicoDetails.getYear());
        semestreAcademico.setPeriodoAcademico(semestreAcademicoDetails.getPeriodoAcademico());
        semestreAcademico.setDescripcion(semestreAcademicoDetails.getDescripcion());
        SemestreAcademico updatedSemestreAcademico = (SemestreAcademico)this.semestreAcademicoRepository.save(semestreAcademico);
        return ResponseEntity.ok(updatedSemestreAcademico);
    }

    @DeleteMapping({"/semestreAcademicos/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteSemestreAcademico(@PathVariable Long id) {
        SemestreAcademico semestreAcademico = (SemestreAcademico)this.semestreAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SemestreAcademico not exist with id :" + id));
        this.semestreAcademicoRepository.delete(semestreAcademico);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

