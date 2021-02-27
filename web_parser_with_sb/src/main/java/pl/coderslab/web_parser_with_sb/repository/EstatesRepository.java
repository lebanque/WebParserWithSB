package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Clothing;
import pl.coderslab.web_parser_with_sb.model.sections.Estates;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstatesRepository extends JpaRepository<Estates, Long> {
    Optional<Estates> findById(Long id);
    List<Estates> findAllByOrderByCreated();
    Estates save(Estates estates);
    void deleteById(Long id);
}
