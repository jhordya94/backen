package co.edu.udes.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "predecesora_id")
    private Asignatura predecesora;

    @Column(name = "numero_semestre")
    private String numeroSemestre;

    @Column(name = "numero_creditos")
    private String numeroCreditos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pensum_id")
    @JsonBackReference
    private Pensum pensum;


    public Asignatura() {
    }


    public Asignatura(long id, String codigo, String nombre, Asignatura predecesora, String numeroSemestre, String numeroCreditos, Pensum pensum) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.predecesora = predecesora;
        this.numeroSemestre = numeroSemestre;
        this.numeroCreditos = numeroCreditos;
        this.pensum = pensum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getPredecesora() {
        return predecesora;
    }

    public void setPredecesora(Asignatura predecesora) {
        this.predecesora = predecesora;
    }

    public String getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(String numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public String getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(String numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Pensum getPensum() {
        return pensum;
    }

    public void setPensum(Pensum pensum) {
        this.pensum = pensum;
    }
}