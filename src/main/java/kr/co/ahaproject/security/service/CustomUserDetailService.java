package kr.co.ahaproject.security.service;

import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.mapper.kjs.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Account account = accountMapper.findByUsername(email);

        if(account == null ){
            throw new UsernameNotFoundException("해당하는 유저의 정보를 찾을 수 없습니다.");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(account.getAc_role()));

        AccountContext accountContext = new AccountContext(account, roles);

        return accountContext;
    }


}
