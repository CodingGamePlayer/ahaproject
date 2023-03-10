package kr.co.ahaproject.security.config;

import kr.co.ahaproject.security.common.AjaxLoginAuthenticationEntryPoint;
import kr.co.ahaproject.security.filter.AjaxLoginProcessingFilter;
import kr.co.ahaproject.security.hadler.AjaxAccessDeniedHandler;
import kr.co.ahaproject.security.hadler.AjaxAuthenticationFailureHandler;
import kr.co.ahaproject.security.hadler.AjaxAuthenticationSuccessHandler;
import kr.co.ahaproject.security.provider.AjaxAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Order(0)
public class AjaxSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(ajaxAuthenticationProvider());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
        return new AjaxAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler ajaxAuthenticationFailureHandler() {
        return new AjaxAuthenticationFailureHandler();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/login", "/api/register").permitAll()
                .antMatchers("/api/user/**").access("hasRole('USER') or hasRole('ADMIN')")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        .and()
                .addFilterBefore(ajaxLoginProcessingFilter(), UsernamePasswordAuthenticationFilter.class )
                .exceptionHandling()
                .authenticationEntryPoint(new AjaxLoginAuthenticationEntryPoint())
                .accessDeniedHandler(ajaxAccessDeniedHandler())
                ;
        http
                .csrf().disable()
                ;

//        customConfigurerAjax(http);
    }

    private void customConfigurerAjax(HttpSecurity http) throws Exception {
        http
                .apply(new AjaxLoginConfigurer<>())
                .successHandlerAjax(ajaxAuthenticationSuccessHandler())
                .failureHandlerAjax(ajaxAuthenticationFailureHandler())
                .setAuthenticationManager(authenticationManagerBean())
                .loginProcessingUrl("/api/login");

    }

    @Bean
    public AccessDeniedHandler ajaxAccessDeniedHandler() {
        return new AjaxAccessDeniedHandler();
    }

    @Bean
    public AuthenticationProvider ajaxAuthenticationProvider() {
        return new AjaxAuthenticationProvider();
    }

    @Bean
    public AjaxLoginProcessingFilter ajaxLoginProcessingFilter() throws Exception {
        AjaxLoginProcessingFilter ajaxLoginProcessingFilter = new AjaxLoginProcessingFilter();

        ajaxLoginProcessingFilter.setAuthenticationManager(authenticationManagerBean());
        ajaxLoginProcessingFilter.setAuthenticationSuccessHandler(ajaxAuthenticationSuccessHandler());
        ajaxLoginProcessingFilter.setAuthenticationFailureHandler(ajaxAuthenticationFailureHandler());
        return ajaxLoginProcessingFilter;
    }
}
