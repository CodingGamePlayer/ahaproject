package kr.co.ahaproject.service.kjs;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    int register(AccountDTO accountDTO);

    AccountDTO findByUsername(String username);
}
