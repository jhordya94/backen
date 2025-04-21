package co.edu.udes.backend.models;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "aulas_horarios"
)
public class AulaHorario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @ManyToOne
    @JoinColumn(
            name = "aula_id"
    )
    private Aula aula;
    @ManyToOne
    @JoinColumn(
            name = "horario_id"
    )
    private Horario horario;
    @Column(
            name = "estado"
    )
    private boolean estado;
    @ManyToOne
    @JoinColumn(
            name = "curso_id"
    )
    private Curso curso;

    public AulaHorario() {
    }

    public AulaHorario(long id, Aula aula, Horario horario, boolean estado, Curso curso) {
        this.id = id;
        this.aula = aula;
        this.horario = horario;
        this.estado = estado;
        this.curso = curso;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aula getAula() {
        return this.aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Horario getHorario() {
        return this.horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

