package portfolioproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import portfolioproject.enun.ProjectStatus;
import portfolioproject.enun.RiskEnum;

import java.util.Date;

@Entity
@Data
@Table(name = "project")
public class ProjectEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false, length = 200)
        private String name;

        @Column(name = "start_date")
        private Date startDate;

        @Column(name = "expected_end_date")
        private Date expectedEndDate;

        @Column(name = "actual_end_date")
        private Date actualEndDate;

        @Column(name = "description", length = 5000)
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(name = "status", length = 45)
        private ProjectStatus status;

        @Column(name = "budget")
        private Float budget;

        @Enumerated(EnumType.STRING)
        @Column(name = "risk", length = 45)
        private RiskEnum risk;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "manager_id", nullable = false)
        private PersonEntity manager;

}
