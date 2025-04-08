package co.edu.udes.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "poligrafos")
public class Poligrafo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "nota_id")
    private Calificaciones Calificaciones;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private SemestreAcademico semestreAcademico; // Ajustado a semestreAcademico

    @Column(name = "creditos_matriculados")
    private int creditosMatriculados;

    @Column(name = "promedio")
    private float promedio;

    @Column(name = "creditos_acumulados")
    private int creditosAcumulados;

    @Column(name = "promedio_acumulado")
    private float promedioAcumulado;

    public Poligrafo() {
    }

    public Poligrafo(long id, Estudiante estudiante, Asignatura asignatura, Calificaciones Calificaciones, Date fechaEmision, SemestreAcademico semestreAcademico, int creditosMatriculados, float promedio, int creditosAcumulados, float promedioAcumulado) {
        this.id = id;
        this.estudiante = estudiante;
        this.asignatura = asignatura;
        this.Calificaciones = Calificaciones;
        this.fechaEmision = fechaEmision;
        this.semestreAcademico = semestreAcademico;
        this.creditosMatriculados = creditosMatriculados;
        this.promedio = promedio;
        this.creditosAcumulados = creditosAcumulados;
        this.promedioAcumulado = promedioAcumulado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Calificaciones getNota() {
        return Calificaciones;
    }

    public void setNota(Calificaciones Calificaciones) {
        this.Calificaciones = Calificaciones;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public SemestreAcademico getSemestreAcademico() { // Asegúrate de que el nombre coincide
        return semestreAcademico; // Asegúrate de que el nombre coincide
    }

    public void setSemestreAcademico(SemestreAcademico semestreAcademico) { // Asegúrate de que el nombre coincide
        this.semestreAcademico = semestreAcademico; // Asegúrate de que el nombre coincide
    }

    public int getCreditosMatriculados() {
        return creditosMatriculados;
    }

    public void setCreditosMatriculados(int creditosMatriculados) {
        this.creditosMatriculados = creditosMatriculados;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getCreditosAcumulados() {
        return creditosAcumulados;
    }

    public void setCreditosAcumulados(int creditosAcumulados) {
        this.creditosAcumulados = creditosAcumulados;
    }

    public float getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }
}