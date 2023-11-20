package portfolioproject.service;

import org.springframework.stereotype.Service;
import portfolioproject.dto.MemberDTO;

@Service
public interface MemberService {
    MemberDTO createMember(MemberDTO memberDTO);
}
