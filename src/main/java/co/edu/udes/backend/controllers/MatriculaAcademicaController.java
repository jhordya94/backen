package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.MatriculaAcademica;
import co.edu.udes.backend.services.MatriculaAcademicaService;
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
public class MatriculaAcademicaController {

    @Autowired
    private MatriculaAcademicaService matriculaAcademicaService;

    // Obtener todas las matrículas
    @GetMapping("/matriculaAcademicas")
    public List<MatriculaAcademica> getAllMatriculaAcademicas() {
        return matriculaAcademicaService.listarTodas();
    }

    // Crear una nueva matrícula
    @PostMapping("/matriculaAcademicas")
    public MatriculaAcademica createMatriculaAcademica(@RequestBody MatriculaAcademica matriculaAcademica) {
        return matriculaAcademicaService.crear(matriculaAcademica);
    }

    // Obtener matrícula por ID
    @GetMapping("/matriculaAcademicas/{id}")
    public ResponseEntity<MatriculaAcademica> getMatriculaAcademicaById(@PathVariable Long id) {
        MatriculaAcademica matricula = matriculaAcademicaService.buscarPorId(id);
        return ResponseEntity.ok(matricula);
    }

    // Actualizar matrícula
    @PutMapping("/matriculaAcademicas/{id}")
    public ResponseEntity<MatriculaAcademica> updateMatriculaAcademica(
            @PathVariable Long id,
            @RequestBody MatriculaAcademica matriculaAcademicaDetails) {
        MatriculaAcademica updatedMatricula = matriculaAcademicaService.actualizar(id, matriculaAcademicaDetails);
        return ResponseEntity.ok(updatedMatricula);
    }

    // Eliminar matrícula
    @DeleteMapping("/matriculaAcademicas/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMatriculaAcademica(@PathVariable Long id) {
        matriculaAcademicaService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
