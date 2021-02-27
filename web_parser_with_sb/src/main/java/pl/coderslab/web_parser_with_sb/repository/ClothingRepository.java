package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;
import pl.coderslab.web_parser_with_sb.model.sections.Clothing;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {

    Optional<Clothing> findById(Long id);
    List<Clothing> findAllByOrderByCreated();
    Clothing save(Clothing clothing);
    void deleteById(Long id);
}
