package co.edu.udes.backend.repositories;

import co.edu.udes.backend.controllers.TipoGeneroController;
import co.edu.udes.backend.models.Employee;
import co.edu.udes.backend.models.TipoGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGeneroRepository extends JpaRepository<TipoGenero, Long> {


}
