package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Estates;
import pl.coderslab.web_parser_with_sb.model.sections.Services;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {
    Optional<Services> findById(Long id);
    List<Services> findAllByOrderByCreated();
    Services save(Services services);
    void deleteById(Long id);
}
