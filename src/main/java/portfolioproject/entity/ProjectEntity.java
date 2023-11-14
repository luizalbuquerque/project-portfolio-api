package portfolioproject.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "project")
public class ProjectEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "data_inicio")
        private Date dataInicio;

}
