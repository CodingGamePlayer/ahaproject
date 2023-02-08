package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    int register(AccountDTO accountDTO);

    AccountDTO findByUsername(String username);

    List<AccountDTO> selectAll();

    int changeRole(AccountDTO accountDTO);

    int delete(AccountDTO accountDTO);
}
