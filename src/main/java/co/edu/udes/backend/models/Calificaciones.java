package co.edu.udes.backend.models;

import jakarta.persistence.*;


@Entity(name = "Calificaciones")

public class Calificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "p1")
    private float p1;

    @Column(name = "p2")
    private float p2;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(name = "definitiva")
    private double definitiva;



    public Calificaciones() {
    }


    public Calificaciones(long id, float p1, float p2, Curso curso, double definitiva) {
        this.id = id;
        this.p1 = p1;
        this.p2 = p2;
        this.curso = curso;
        this.definitiva = definitiva;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getP1() {
        return p1;
    }

    public void setP1(float p1) {
        this.p1 = p1;
    }

    public float getP2() {
        return p2;
    }

    public void setP2(float p2) {
        this.p2 = p2;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(double definitiva) {
        this.definitiva = definitiva;
    }

}