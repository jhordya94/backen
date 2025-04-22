package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Asignatura;
import co.edu.udes.backend.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // Obtener todas las asignaturas
    @GetMapping("/asignaturas")
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaService.listarTodas();
    }

    // Crear una nueva asignatura
    @PostMapping("/asignaturas")
    public Asignatura createAsignatura(@RequestBody Asignatura asignatura) {
        return asignaturaService.crear(asignatura);
    }

    // Obtener asignatura por ID
    @GetMapping("/asignaturas/{id}")
    public ResponseEntity<Asignatura> getAsignaturaById(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.buscarPorId(id);
        return ResponseEntity.ok(asignatura);
    }

    // Actualizar asignatura
    @PutMapping("/asignaturas/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaDetails) {
        Asignatura updated = asignaturaService.actualizar(id, asignaturaDetails);
        return ResponseEntity.ok(updated);
    }

    // Eliminar asignatura
    @DeleteMapping("/asignaturas/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAsignatura(@PathVariable Long id) {
        asignaturaService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
