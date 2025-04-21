package co.edu.udes.backend.repositories;

import co.edu.udes.backend.models.Asignatura;
import co.edu.udes.backend.models.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {

    List<ProgramaAcademico> findProgramaAcademicoByFacultadId(Long facultadId);


}
