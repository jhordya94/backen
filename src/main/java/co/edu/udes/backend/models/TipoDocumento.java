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

@Entity(
        name = "tipos_documentos"
)
public class TipoDocumento {
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
            name = "estado"
    )
    private boolean estado;

    public TipoDocumento() {
    }

    public TipoDocumento(long id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
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

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

