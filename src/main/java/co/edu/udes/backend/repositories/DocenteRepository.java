package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
}
