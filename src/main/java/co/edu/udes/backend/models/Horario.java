package co.edu.udes.backend.models;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Time;

@Entity
@Table(
        name = "horarios"
)
public class Horario {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "hora_inicio"
    )
    private Time horaInicio;
    @Column(
            name = "hora_finalizacion"
    )
    private Time horafinalizacion;
    @Column(
            name = "dia"
    )
    private String dia;
    @Column(
            name = "estado"
    )
    private boolean estado;

    public Horario() {
    }

    public Horario(long id, Time horaInicio, Time horafinalizacion, String dia, boolean estado) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horafinalizacion = horafinalizacion;
        this.dia = dia;
        this.estado = estado;
    }

    public Horario(Time horaInicio, Time horafinalizacion, String dia, boolean estado) {
        this.horaInicio = horaInicio;
        this.horafinalizacion = horafinalizacion;
        this.dia = dia;
        this.estado = estado;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHorafinalizacion() {
        return this.horafinalizacion;
    }

    public void setHorafinalizacion(Time horafinalizacion) {
        this.horafinalizacion = horafinalizacion;
    }

    public String getDia() {
        return this.dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

