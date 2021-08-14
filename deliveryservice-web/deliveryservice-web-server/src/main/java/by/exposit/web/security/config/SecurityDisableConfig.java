package by.exposit.web.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(prefix = "security", name = "enabled", havingValue = "false")
public class SecurityDisableConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) {
    web
        .ignoring().antMatchers("/**");
  }
}
