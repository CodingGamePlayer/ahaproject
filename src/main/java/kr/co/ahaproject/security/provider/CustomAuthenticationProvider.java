package kr.co.ahaproject.security.provider;

import kr.co.ahaproject.security.service.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;
//
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("Authentication : " + authentication);
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        log.info(username);
        log.info(password);
        UserContext userContext = (UserContext) userDetailsService.loadUserByUsername(username);

        if(!passwordEncoder.matches(password, userContext.getPassword())){
            throw new BadCredentialsException("BadCredentialException");
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userContext.getAccount(), null, userContext.getAuthorities());


        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
