package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Docente;
import co.edu.udes.backend.services.DocenteService;
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
    private DocenteService docenteService;

    // Obtener todos los docentes
    @GetMapping("/docentes")
    public List<Docente> getAllDocentes() {
        return docenteService.listarTodos();
    }

    // Crear nuevo docente
    @PostMapping("/docentes")
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.crear(docente);
    }

    // Obtener docente por ID
    @GetMapping("/docentes/{id}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable Long id) {
        Docente docente = docenteService.buscarPorId(id);
        return ResponseEntity.ok(docente);
    }

    // Actualizar docente
    @PutMapping("/docentes/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Long id, @RequestBody Docente docenteDetails) {
        Docente updatedDocente = docenteService.actualizar(id, docenteDetails);
        return ResponseEntity.ok(updatedDocente);
    }

    // Eliminar docente
    @DeleteMapping("/docentes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDocente(@PathVariable Long id) {
        docenteService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
