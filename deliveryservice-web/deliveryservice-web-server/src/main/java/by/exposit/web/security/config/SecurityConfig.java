package by.exposit.web.security.config;

import by.exposit.web.security.encoder.CustomPasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(prefix = "security", name = "enabled", havingValue = "true")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;

  public SecurityConfig(UserDetailsService userDetailsService){
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET,"/**").hasAnyRole("ADMIN", "USER")
        .antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  protected PasswordEncoder passwordEncoder(){
    return new CustomPasswordEncoder();
  }

  @Bean
  protected DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return daoAuthenticationProvider;
  }
}
