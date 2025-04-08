package co.edu.udes.backend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "aulahorarios")
public class AulaHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



}
