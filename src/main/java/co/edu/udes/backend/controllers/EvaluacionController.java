package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Evaluacion;
import co.edu.udes.backend.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    // Obtener todas las evaluaciones
    @GetMapping("/evaluaciones")
    public List<Evaluacion> getAllEvaluaciones() {
        return evaluacionService.listarTodas();
    }

    // Crear una nueva evaluación
    @PostMapping("/evaluaciones")
    public Evaluacion createEvaluacion(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crear(evaluacion);
    }

    // Obtener evaluación por ID
    @GetMapping("/evaluaciones/{id}")
    public ResponseEntity<Evaluacion> getEvaluacionById(@PathVariable Long id) {
        Evaluacion evaluacion = evaluacionService.buscarPorId(id);
        return ResponseEntity.ok(evaluacion);
    }

    // Actualizar evaluación
    @PutMapping("/evaluaciones/{id}")
    public ResponseEntity<Evaluacion> updateEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacionDetails) {
        Evaluacion updated = evaluacionService.actualizar(id, evaluacionDetails);
        return ResponseEntity.ok(updated);
    }

    // Eliminar evaluación
    @DeleteMapping("/evaluaciones/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEvaluacion(@PathVariable Long id) {
        evaluacionService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
