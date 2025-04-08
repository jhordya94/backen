package co.edu.udes.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "docentes")  // Esta es la tabla que se generará en la BD
public class Docente extends Persona {

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "experiencia")
    private int experiencia;

    public Docente() {
        super();  // Llama al constructor de Persona
    }

    public Docente(String profesion, String titulo, int experiencia) {
        this.profesion = profesion;
        this.titulo = titulo;
        this.experiencia = experiencia;
    }

    public Docente(long id, String nombre, String telefono, String correoPersonal, LocalDate fechaNacimiento, String numeroDocumento, boolean estado, String profesion, String titulo, int experiencia) {
        super(id, nombre, telefono, correoPersonal, fechaNacimiento, numeroDocumento, estado);
        this.profesion = profesion;
        this.titulo = titulo;
        this.experiencia = experiencia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }




}
