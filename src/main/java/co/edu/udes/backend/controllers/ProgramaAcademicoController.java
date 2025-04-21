package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.ProgramaAcademico;
import co.edu.udes.backend.repositories.ProgramaAcademicoRepository;
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
public class ProgramaAcademicoController {
    @Autowired
    private ProgramaAcademicoRepository programaAcademicoRepository;

    public ProgramaAcademicoController() {
    }

    @GetMapping({"/programaAcademicos"})
    public List<ProgramaAcademico> getAllProgramaAcademicos() {
        return this.programaAcademicoRepository.findAll();
    }

    @PostMapping({"/programaAcademicos"})
    public ProgramaAcademico createProgramaAcademico(@RequestBody ProgramaAcademico programaAcademico) {
        return (ProgramaAcademico)this.programaAcademicoRepository.save(programaAcademico);
    }

    @GetMapping({"/programaAcademicos/{id}"})
    public ResponseEntity<ProgramaAcademico> getProgramaAcademicoById(@PathVariable Long id) {
        ProgramaAcademico programaAcademico = (ProgramaAcademico)this.programaAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaAcademico not exist with id :" + id));
        return ResponseEntity.ok(programaAcademico);
    }

    @PutMapping({"/programaAcademicos/{id}"})
    public ResponseEntity<ProgramaAcademico> updateProgramaAcademico(@PathVariable Long id, @RequestBody ProgramaAcademico programaAcademicoDetails) {
        ProgramaAcademico programaAcademico = (ProgramaAcademico)this.programaAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaAcademico not exist with id :" + id));
        programaAcademico.setCodigoPrograma(programaAcademicoDetails.getCodigoPrograma());
        programaAcademico.setNombrePrograma(programaAcademicoDetails.getNombrePrograma());
        programaAcademico.setPensums(programaAcademicoDetails.getPensums());
        programaAcademico.setDescripcion(programaAcademicoDetails.getDescripcion());
        programaAcademico.setEstado(programaAcademicoDetails.getEstado());
        programaAcademico.setFacultad(programaAcademicoDetails.getFacultad());
        programaAcademico.setCreditosPrograma(programaAcademicoDetails.getCreditosPrograma());
        programaAcademico.setCursos(programaAcademicoDetails.getCursos());
        ProgramaAcademico updatedProgramaAcademico = (ProgramaAcademico)this.programaAcademicoRepository.save(programaAcademico);
        return ResponseEntity.ok(updatedProgramaAcademico);
    }

    @DeleteMapping({"/programaAcademicos/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteProgramaAcademico(@PathVariable Long id) {
        ProgramaAcademico programaAcademico = (ProgramaAcademico)this.programaAcademicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProgramaAcademico not exist with id :" + id));
        this.programaAcademicoRepository.delete(programaAcademico);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping({"/programaAcademicos/facultad/{id}"})
    public List<ProgramaAcademico> getProgramaAcademicoByFacultadId(@PathVariable Long id) {
        List<ProgramaAcademico> programaAcademicos = this.programaAcademicoRepository.findProgramaAcademicoByFacultadId(id);
        return programaAcademicos;
    }
}

