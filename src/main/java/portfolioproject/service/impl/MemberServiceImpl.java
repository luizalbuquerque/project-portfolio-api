package portfolioproject.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import portfolioproject.dto.MemberDTO;
import portfolioproject.entity.MembersEntity;
import portfolioproject.entity.PersonEntity;
import portfolioproject.entity.ProjectEntity;
import portfolioproject.repository.MembersRepository;
import portfolioproject.repository.PersonRepository;
import portfolioproject.repository.ProjectRepository;
import portfolioproject.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    private MembersRepository membersRepository;
    private ProjectRepository projectRepository;
    private PersonRepository personRepository;

    @Override
    public MemberDTO createMember(MemberDTO memberDTO) {
        // Verifique se o projeto e a pessoa existem no banco de dados
        ProjectEntity projectEntity = projectRepository.findById(memberDTO.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));

        PersonEntity personEntity = personRepository.findById(memberDTO.getPersonId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        // Verifique se a pessoa tem a atribuição de funcionário
        if (!personEntity.isEmployee()) {
            throw new IllegalArgumentException("Atribuição de funcionário é necessária para associar a um projeto.");
        }

        // Crie uma nova associação de membro
        MembersEntity memberEntity = new MembersEntity();
        memberEntity.setProject(projectEntity);
        memberEntity.setPerson(personEntity);

        // Salve a associação no banco de dados
        memberEntity = membersRepository.save(memberEntity);

        // Crie e retorne o DTO com os dados da associação de membro criada
        MemberDTO createdMember = new MemberDTO();
        createdMember.setProjectId(memberEntity.getProject().getId());
        createdMember.setPersonId(memberEntity.getPerson().getId());

        return createdMember;
    }
}
