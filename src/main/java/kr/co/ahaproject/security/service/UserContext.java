package kr.co.ahaproject.security.service;

import kr.co.ahaproject.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserContext extends User {

    private final Account account;

    public UserContext(Account user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getAc_password(), authorities);
        this.account = user;
    }


    public Account getAccount() {
        return account;
    }
}
