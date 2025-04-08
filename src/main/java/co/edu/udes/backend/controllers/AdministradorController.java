package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Administrador;
import co.edu.udes.backend.repositories.AdministradorRepository;
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
public class AdministradorController {

    @Autowired
    private AdministradorRepository administradorRepository;

    // Get all administradores
    @GetMapping("/administradores")
    public List<Administrador> getAllAdministradores() {
        return administradorRepository.findAll();
    }

    // Create administrador rest api
    @PostMapping("/administradores")
    public Administrador createAdministrador(@RequestBody Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    // Get administrador by id rest api
    @GetMapping("/administradores/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador not exist with id :" + id));
        return ResponseEntity.ok(administrador);
    }

    // Update administrador rest api
    @PutMapping("/administradores/{id}")
    public ResponseEntity<Administrador> updateAdministrador(@PathVariable Long id, @RequestBody Administrador administradorDetails) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador not exist with id :" + id));

        administrador.setFacultad(administradorDetails.getFacultad());
        administrador.setCodigoInstitucional(administradorDetails.getCodigoInstitucional());
        administrador.setCorreoInstitucional(administradorDetails.getCorreoInstitucional());
        Administrador updatedAdministrador = administradorRepository.save(administrador);
        return ResponseEntity.ok(updatedAdministrador);
    }

    // Delete administrador rest api
    @DeleteMapping("/administradores/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAdministrador(@PathVariable Long id) {
        Administrador administrador = administradorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador not exist with id :" + id));

        administradorRepository.delete(administrador);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}