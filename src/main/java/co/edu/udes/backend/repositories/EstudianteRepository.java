package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Estudiante;
import co.edu.udes.backend.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {


}
