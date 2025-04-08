package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Persona;
import co.edu.udes.backend.repositories.PersonaRepository;
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
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Get all personas
    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Create persona rest api
    @PostMapping("/personas")
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Get persona by id rest api
    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));
        return ResponseEntity.ok(persona);
    }

    // Update persona rest api
    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));

        persona.setNombre(personaDetails.getNombre());
        persona.setTelefono(personaDetails.getTelefono());
        persona.setCorreoPersonal(personaDetails.getCorreoPersonal());
        persona.setFechaNacimiento(personaDetails.getFechaNacimiento());
        persona.setNumeroDocumento(personaDetails.getNumeroDocumento());
        persona.setEstado(personaDetails.isEstado());


        Persona updatedPersona = personaRepository.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    // Delete persona rest api
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePersona(@PathVariable Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona not exist with id :" + id));

        personaRepository.delete(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}