package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Asistencia;
import co.edu.udes.backend.services.AsistenciaService;
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
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    // Obtener todas las asistencias
    @GetMapping("/asistencias")
    public List<Asistencia> getAllAsistencias() {
        return asistenciaService.listarTodas();
    }

    // Crear nueva asistencia (con validación de duplicados)
    @PostMapping("/asistencias")
    public Asistencia createAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaService.registrar(asistencia);
    }

    // Obtener asistencia por ID
    @GetMapping("/asistencias/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable Long id) {
        Asistencia asistencia = asistenciaService.buscarPorId(id);
        return ResponseEntity.ok(asistencia);
    }

    // Actualizar asistencia
    @PutMapping("/asistencias/{id}")
    public ResponseEntity<Asistencia> updateAsistencia(
            @PathVariable Long id,
            @RequestBody Asistencia asistenciaDetails) {
        Asistencia updated = asistenciaService.actualizar(id, asistenciaDetails);
        return ResponseEntity.ok(updated);
    }

    // Eliminar asistencia
    @DeleteMapping("/asistencias/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAsistencia(@PathVariable Long id) {
        asistenciaService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
