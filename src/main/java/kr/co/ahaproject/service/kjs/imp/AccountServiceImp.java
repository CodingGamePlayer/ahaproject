package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public int register(AccountDTO accountDTO) {

        if (accountDTO == null){
            return 0;
        }


        accountDTO.setAc_password(passwordEncoder.encode(accountDTO.getAc_password()));
        Account account = modelMapper.map(accountDTO, Account.class);

        int register = accountMapper.register(account);

        if (!(register > 0)){
            return 0;
        }

        return 1;
    }

    @Override
    public AccountDTO findByUsername(String username) {


        Account result = accountMapper.findByUsername(username);

        return modelMapper.map(result, AccountDTO.class);
    }
}
