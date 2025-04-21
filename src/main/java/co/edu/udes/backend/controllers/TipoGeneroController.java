package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.TipoGenero;
import co.edu.udes.backend.repositories.TipoGeneroRepository;
import co.edu.udes.backend.utils.ResourceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping({"/api/v1/"})
public class TipoGeneroController {
    @Autowired
    private TipoGeneroRepository tipoGeneroRepository;

    public TipoGeneroController() {
    }

    @GetMapping({"/tipos_generos"})
    public List<TipoGenero> getAllTiposGenero() {
        return this.tipoGeneroRepository.findAll();
    }

    @PostMapping({"/tipos_generos"})
    public TipoGenero createTipoGenero(@RequestBody TipoGenero tipoGenero) {
        return (TipoGenero)this.tipoGeneroRepository.save(tipoGenero);
    }

    @GetMapping({"/tipos_generos/{id}"})
    public ResponseEntity<TipoGenero> getTipoGeneroById(@PathVariable Long id) {
        TipoGenero tipoGenero = (TipoGenero)this.tipoGeneroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoGenero not exist with id :" + id));
        return ResponseEntity.ok(tipoGenero);
    }

    @PutMapping({"/tipos_generos/{id}"})
    public ResponseEntity<TipoGenero> updateTipoGenero(@PathVariable Long id, @RequestBody TipoGenero tipoGeneroDetails) {
        TipoGenero tipoGenero = (TipoGenero)this.tipoGeneroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoGenero not exist with id :" + id));
        tipoGenero.setNombre(tipoGeneroDetails.getNombre());
        tipoGenero.setEstado(tipoGeneroDetails.isEstado());
        TipoGenero updatedTipoGenero = (TipoGenero)this.tipoGeneroRepository.save(tipoGenero);
        return ResponseEntity.ok(updatedTipoGenero);
    }

    @DeleteMapping({"/tipos_generos/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteTipoGenero(@PathVariable Long id) {
        TipoGenero tipoGenero = (TipoGenero)this.tipoGeneroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoGenero not exist with id :" + id));
        this.tipoGeneroRepository.delete(tipoGenero);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

