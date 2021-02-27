package pl.coderslab.web_parser_with_sb.model.sections;

import lombok.Data;
import pl.coderslab.web_parser_with_sb.model.specifics.Contact;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "work")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column
    private String title;
    @NotBlank
    @Column
    private String description;
    @NotNull
    @ManyToMany
    private List<Contact> contact;
    @NotBlank
    @Column
    private final LocalDateTime created = LocalDateTime.now();
}
