package portfolioproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "employee")
    private Boolean employee;

}

