package pl.coderslab.web_parser_with_sb.model.specifics;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private long price;
    private enum String {
        negotiable,
        nonNegotiable
    }

}
