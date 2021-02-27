package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Services;
import pl.coderslab.web_parser_with_sb.model.sections.Work;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkRepository extends JpaRepository <Work, Long> {
    Optional<Work> findById(Long id);
    List<Work> findAllByOrderByCreated();
    Work save(Work work);
    void deleteById(Long id);
}
