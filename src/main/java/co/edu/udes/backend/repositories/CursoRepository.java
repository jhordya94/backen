package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Curso;
import co.edu.udes.backend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {


}
