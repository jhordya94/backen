package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Employee;
import co.edu.udes.backend.models.SemestreAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreAcademicoRepository extends JpaRepository<SemestreAcademico, Long> {


}
