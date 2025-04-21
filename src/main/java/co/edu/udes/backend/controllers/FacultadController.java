package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.Facultad;
import co.edu.udes.backend.repositories.FacultadRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/"})
public class FacultadController {
    @Autowired
    private FacultadRepository facultadRepository;

    public FacultadController() {
    }

    @GetMapping({"/facultades"})
    public List<Facultad> getAllFacultades() {
        return this.facultadRepository.findAll();
    }

    @PostMapping({"/facultades"})
    public Facultad createFacultad(@RequestBody Facultad facultad) {
        return (Facultad)this.facultadRepository.save(facultad);
    }

    @GetMapping({"/facultades/{id}"})
    public ResponseEntity<Facultad> getFacultadById(@PathVariable Long id) {
        Facultad facultad = (Facultad)this.facultadRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facultad not exist with id :" + id));
        return ResponseEntity.ok(facultad);
    }

    @PutMapping({"/facultades/{id}"})
    public ResponseEntity<Facultad> updateFacultad(@PathVariable Long id, @RequestBody Facultad facultadDetails) {
        Facultad facultad = (Facultad)this.facultadRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facultad not exist with id :" + id));
        facultad.setNombre(facultadDetails.getNombre());
        facultad.setEstado(facultadDetails.isEstado());
        Facultad updatedFacultad = (Facultad)this.facultadRepository.save(facultad);
        return ResponseEntity.ok(updatedFacultad);
    }

    @DeleteMapping({"/facultades/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteFacultad(@PathVariable Long id) {
        Facultad facultad = (Facultad)this.facultadRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Facultad not exist with id :" + id));
        this.facultadRepository.delete(facultad);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

