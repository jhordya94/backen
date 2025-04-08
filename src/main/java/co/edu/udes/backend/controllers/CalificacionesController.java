package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Calificaciones;
import co.edu.udes.backend.repositories.CalificacionesRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/v1/")
public class CalificacionesController {

    @Autowired
    private CalificacionesRepository calificacionesRepository;

    // get all calificaciones
    @GetMapping("/calificaciones")
    public List<Calificaciones> getAllCalificaciones() {
        return calificacionesRepository.findAll();
    }

    // create calificacion rest api
    @PostMapping("/calificaciones")
    public Calificaciones createCalificacion(@RequestBody Calificaciones calificacion) {
        return calificacionesRepository.save(calificacion);
    }

    // get calificacion by id rest api
    @GetMapping("/calificaciones/{id}")
    public ResponseEntity<Calificaciones> getCalificacionById(@PathVariable Long id) {
        Calificaciones calificacion = calificacionesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificación no existe con id: " + id));
        return ResponseEntity.ok(calificacion);
    }

    // update calificacion rest api
    @PutMapping("/calificaciones/{id}")
    public ResponseEntity<Calificaciones> updateCalificacion(@PathVariable Long id, @RequestBody Calificaciones calificacionDetails) {
        Calificaciones calificacion = calificacionesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificación no existe con id: " + id));

        calificacion.setP1(calificacionDetails.getP1());
        calificacion.setP2(calificacionDetails.getP2());
        calificacion.setCurso(calificacionDetails.getCurso());
        calificacion.setDefinitiva(calificacionDetails.getDefinitiva());

        Calificaciones updatedCalificacion = calificacionesRepository.save(calificacion);
        return ResponseEntity.ok(updatedCalificacion);
    }

    // delete calificacion rest api
    @DeleteMapping("/calificaciones/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCalificacion(@PathVariable Long id) {
        Calificaciones calificacion = calificacionesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Calificación no existe con id: " + id));

        calificacionesRepository.delete(calificacion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
