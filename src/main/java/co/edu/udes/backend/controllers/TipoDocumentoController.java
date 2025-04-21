package co.edu.udes.backend.controllers;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import co.edu.udes.backend.models.TipoDocumento;
import co.edu.udes.backend.repositories.TipoDocumentoRepository;
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
public class TipoDocumentoController {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoController() {
    }

    @GetMapping({"/tipos_documentos"})
    public List<TipoDocumento> getAllTiposDocumento() {
        return this.tipoDocumentoRepository.findAll();
    }

    @PostMapping({"/tipos_documentos"})
    public TipoDocumento createTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return (TipoDocumento)this.tipoDocumentoRepository.save(tipoDocumento);
    }

    @GetMapping({"/tipos_documentos/{id}"})
    public ResponseEntity<TipoDocumento> getTipoDocumentoById(@PathVariable Long id) {
        TipoDocumento tipoDocumento = (TipoDocumento)this.tipoDocumentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento not exist with id :" + id));
        return ResponseEntity.ok(tipoDocumento);
    }

    @PutMapping({"/tipos_documentos/{id}"})
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable Long id, @RequestBody TipoDocumento tipoDocumentoDetails) {
        TipoDocumento tipoDocumento = (TipoDocumento)this.tipoDocumentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento not exist with id :" + id));
        tipoDocumento.setNombre(tipoDocumentoDetails.getNombre());
        tipoDocumento.setEstado(tipoDocumentoDetails.isEstado());
        TipoDocumento updatedTipoDocumento = (TipoDocumento)this.tipoDocumentoRepository.save(tipoDocumento);
        return ResponseEntity.ok(updatedTipoDocumento);
    }

    @DeleteMapping({"/tipos_documentos/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteTipoDocumento(@PathVariable Long id) {
        TipoDocumento tipoDocumento = (TipoDocumento)this.tipoDocumentoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento not exist with id :" + id));
        this.tipoDocumentoRepository.delete(tipoDocumento);
        Map<String, Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

