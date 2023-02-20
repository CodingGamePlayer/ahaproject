package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.AccountListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    int register(AccountDTO accountDTO);

    AccountDTO findByUsername(String username);

    List<AccountDTO> selectAll();

    int changeRole(AccountDTO accountDTO);

    int delete(AccountDTO accountDTO);

    PageResponseDTO<AccountListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
}
