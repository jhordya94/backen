package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Poligrafo;
import co.edu.udes.backend.repositories.PoligrafoRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost")
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/")
public class PoligrafoController {

    @Autowired
    private PoligrafoRepository poligrafoRepository;

    // get all poligrafos
    @GetMapping("/poligrafos")
    public List<Poligrafo> getAllPoligrafos(){
        return poligrafoRepository.findAll();
    }

    // create poligrafo rest api
    @PostMapping("/poligrafos")
    public Poligrafo createPoligrafo(@RequestBody Poligrafo poligrafo) {
        return poligrafoRepository.save(poligrafo);
    }

    // get poligrafo by id rest api
    @GetMapping("/poligrafos/{id}")
    public ResponseEntity<Poligrafo> getPoligrafoById(@PathVariable Long id) {
        Poligrafo poligrafo = poligrafoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Poligrafo not exist with id :" + id));
        return ResponseEntity.ok(poligrafo);
    }

    // update poligrafo rest api

    @PutMapping("/poligrafos/{id}")
    public ResponseEntity<Poligrafo> updatePoligrafo(@PathVariable Long id, @RequestBody Poligrafo poligrafoDetails){
        Poligrafo poligrafo = poligrafoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Poligrafo not exist with id :" + id));

        poligrafo.setEstudiante(poligrafoDetails.getEstudiante());
        poligrafo.setAsignatura(poligrafoDetails.getAsignatura());
        poligrafo.setNota(poligrafoDetails.getNota());
        poligrafo.setFechaEmision(poligrafoDetails.getFechaEmision());
        poligrafo.setSemestreAcademico(poligrafoDetails.getSemestreAcademico());
        poligrafo.setCreditosMatriculados(poligrafoDetails.getCreditosMatriculados());
        poligrafo.setPromedio(poligrafoDetails.getPromedio());
        poligrafo.setCreditosAcumulados(poligrafoDetails.getCreditosAcumulados());
        poligrafo.setPromedioAcumulado(poligrafoDetails.getPromedioAcumulado());


        Poligrafo updatedPoligrafo = poligrafoRepository.save(poligrafo);
        return ResponseEntity.ok(updatedPoligrafo);
    }

    // delete poligrafo rest api
    @DeleteMapping("/poligrafos/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePoligrafo(@PathVariable Long id){
        Poligrafo poligrafo = poligrafoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Poligrafo not exist with id :" + id));

        poligrafoRepository.delete(poligrafo);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}