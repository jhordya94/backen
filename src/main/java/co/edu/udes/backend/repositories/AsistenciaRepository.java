package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Asistencia;
import co.edu.udes.backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    boolean existsByEstudianteIdAndCursoIdAndFecha(Long estudianteId, Long cursoId, LocalDate fecha);


}
