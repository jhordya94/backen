package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Curso;
import co.edu.udes.backend.services.CursoService;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Obtener todos los cursos
    @GetMapping("/cursos")
    public List<Curso> getAllCursos() {
        return cursoService.listarTodos();
    }

    // Crear un nuevo curso
    @PostMapping("/cursos")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.crear(curso);
    }

    // Obtener curso por ID
    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(curso);
    }

    // Actualizar curso
    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        Curso updatedCurso = cursoService.actualizar(id, cursoDetails);
        return ResponseEntity.ok(updatedCurso);
    }

    // Eliminar curso
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCurso(@PathVariable Long id) {
        cursoService.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
