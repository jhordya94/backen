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

@Entity
@Table(
        name = "aulas"
)
public class Aula {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "nombre"
    )
    private String nombre;
    @Column(
            name = "codigo"
    )
    private String codigo;
    @Column(
            name = "bloque"
    )
    private String bloque;
    @Column(
            name = "estado"
    )
    private boolean estado;

    public Aula() {
    }

    public Aula(long id, String nombre, String codigo, String bloque, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.bloque = bloque;
        this.estado = estado;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBloque() {
        return this.bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

