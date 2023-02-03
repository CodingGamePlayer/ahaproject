package kr.co.ahaproject.security.service;

import kr.co.ahaproject.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AccountContext extends User {

    private final Account account;

    public AccountContext(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getUsername(), account.getAc_password(), authorities);

        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
