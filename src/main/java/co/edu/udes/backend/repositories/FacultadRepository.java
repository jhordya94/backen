package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Administrador;
import co.edu.udes.backend.models.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long> {


}
