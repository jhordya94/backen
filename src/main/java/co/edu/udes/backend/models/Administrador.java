package co.edu.udes.backend.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity(name = "administradores")
public class Administrador extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    @Column(name = "codigo_institucional")
    private String codigoInstitucional;

    @Column(name = "correo_institucional")
    private String correoInstitucional;

    public Administrador() {
    }

    public Administrador(long id, String nombre, String telefono, String correoPersonal, LocalDate fechaNacimiento, String numeroDocumento, boolean estado, long id1, Facultad facultad, String codigoInstitucional, String correoInstitucional) {
        super();
        this.id = id;
        this.facultad = facultad;
        this.codigoInstitucional = codigoInstitucional;
        this.correoInstitucional = correoInstitucional;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public String getCodigoInstitucional() {
        return codigoInstitucional;
    }

    public void setCodigoInstitucional(String codigoInstitucional) {
        this.codigoInstitucional = codigoInstitucional;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }
}