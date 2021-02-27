package pl.coderslab.web_parser_with_sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.web_parser_with_sb.model.specifics.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository <Localization, Long> {
}
