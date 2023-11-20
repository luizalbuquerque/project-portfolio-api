package portfolioproject.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDTO {

    private Long id;
    private String name;
    private Date dataInicio;
    private String descricao;

}
