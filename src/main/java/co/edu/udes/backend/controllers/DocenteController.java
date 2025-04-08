package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Docente;
import co.edu.udes.backend.repositories.DocenteRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/")
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    // Get all docentes
    @GetMapping("/docentes")
    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    // Create docente
    @PostMapping("/docentes")
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteRepository.save(docente);
    }

    // Get docente by ID
    @GetMapping("/docentes/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente not found with id: " + id));
        return ResponseEntity.ok(docente);
    }

    // Update docente
    @PutMapping("/docentes/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Long id, @RequestBody Docente docenteDetails) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente not found with id: " + id));

        // Atributos de Persona
        docente.setNombre(docenteDetails.getNombre());
        docente.setTelefono(docenteDetails.getTelefono());
        docente.setCorreoPersonal(docenteDetails.getCorreoPersonal());
        docente.setFechaNacimiento(docenteDetails.getFechaNacimiento());
        docente.setNumeroDocumento(docenteDetails.getNumeroDocumento());
        docente.setEstado(docenteDetails.isEstado());

        // Atributos propios de Docente
        docente.setProfesion(docenteDetails.getProfesion());
        docente.setTitulo(docenteDetails.getTitulo());
        docente.setExperiencia(docenteDetails.getExperiencia());

        Docente updatedDocente = docenteRepository.save(docente);
        return ResponseEntity.ok(updatedDocente);
    }

    // Delete docente
    @DeleteMapping("/docentes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDocente(@PathVariable Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente not found with id: " + id));

        docenteRepository.delete(docente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
