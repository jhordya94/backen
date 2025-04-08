package co.edu.udes.backend.models;

import jakarta.persistence.*;
import org.w3c.dom.html.HTMLImageElement;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "matriculas_academicas")
public class MatriculaAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo")
    private String codigo;


    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estado")
    private boolean estado;

    @OneToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToMany
    @JoinTable(
            name = "matriculas_cursos",
            joinColumns = @JoinColumn(name = "matricula_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    @Column(name = "semestre_academico")
    private String semestre;

    @Column(name = "creditos_actuales")
    private int creditosActuales;


    public MatriculaAcademica() {
    }

    public MatriculaAcademica(long id, String codigo, LocalDate fecha, boolean estado,
                              Estudiante estudiante, List<Curso> cursos, String semestre,
                              int creditosActuales) {
        this.id = id;
        this.codigo = codigo;
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.cursos = cursos;
        this.semestre = semestre;
        this.creditosActuales = creditosActuales;
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
    //
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getCreditosActuales() {
        return creditosActuales;
    }

    public void setCreditosActuales(int creditosActuales) {
        this.creditosActuales = creditosActuales;
    }
}