package kr.co.ahaproject.service.kjs.imp;

import kr.co.ahaproject.dto.AccountDTO;
import kr.co.ahaproject.dto.AccountListDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import kr.co.ahaproject.service.kjs.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AccountDTO> selectAll() {

        List<Account> accounts = accountMapper.selectAll();

        return accounts.stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PageResponseDTO<AccountListDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {

        List<AccountListDTO> accountList = accountMapper.selectAllForPaging(pageRequestDTO);

        int count = accountMapper.getCount(pageRequestDTO);

        PageResponseDTO<AccountListDTO> pageResponseDTO = PageResponseDTO.<AccountListDTO>withAll()
                .dtoList(accountList)
                .total(count)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public int changeRole(AccountDTO accountDTO) {

        Account target = accountMapper.findByUsername(accountDTO.getUsername());

        if (target == null){
            return 0;
        }

        String role = target.getAc_role();

        if (role.equals("ROLE_ADMIN")){
            target.setAc_role("ROLE_USER");
        } else if (role.equals("ROLE_USER")) {
            target.setAc_role("ROLE_ADMIN");
        }

        int result = accountMapper.changeRole(target);

        if (result==0){
            return 0;
        }

        return 1;
    }

    @Override
    public int delete(AccountDTO accountDTO) {

        Account target = accountMapper.findByUsername(accountDTO.getUsername());
        log.info("service target account : {}", target);
        if(target == null) {
            return 0;
        }

        int result = accountMapper.delete(target);

        if (!(result>0)){
            return 0;
        }

        return 1;
    }
}
