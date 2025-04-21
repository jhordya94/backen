package co.edu.udes.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo_Personal")
    private String correoPersonal;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(
            name = "tipo_documento_id"
    )
    private TipoDocumento tipoDocumento;
    @ManyToOne
    @JoinColumn(
            name = "tipo_genero_id"
    )
    private TipoGenero genero;


    public Persona() {
    }

    public Persona(long id, String nombre, String telefono, String correoPersonal, LocalDate fechaNacimiento,
                   String numeroDocumento, boolean estado, TipoDocumento tipoDocumento, TipoGenero genero) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoPersonal = correoPersonal;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
        this.estado = estado;
        this.tipoDocumento = tipoDocumento;
        this.genero = genero;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}