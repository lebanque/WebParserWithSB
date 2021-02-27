package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;
import pl.coderslab.web_parser_with_sb.model.sections.Electronics;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Long> {

    Optional<Electronics> findById(Long id);
    List<Electronics> findAllByOrderByCreated();
    Electronics save(Electronics electronics);
    void deleteById(Long id);
}
