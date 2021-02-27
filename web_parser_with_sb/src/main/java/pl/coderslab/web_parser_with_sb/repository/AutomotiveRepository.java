package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutomotiveRepository extends JpaRepository<Automotive, Long> {

    Optional<Automotive> findById(Long id);
    List<Automotive> findAllByOrderByCreated();
    Automotive save(Automotive automotive);
    void deleteById(Long id);
}
