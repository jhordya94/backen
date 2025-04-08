package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Employee;
import co.edu.udes.backend.models.Poligrafo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoligrafoRepository extends JpaRepository<Poligrafo, Long> {


}
