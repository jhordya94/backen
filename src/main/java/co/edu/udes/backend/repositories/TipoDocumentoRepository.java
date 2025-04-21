package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Employee;
import co.edu.udes.backend.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {


}
