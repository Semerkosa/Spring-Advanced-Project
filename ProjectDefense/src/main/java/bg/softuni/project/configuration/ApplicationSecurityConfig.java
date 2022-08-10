package bg.softuni.project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/js/**", "/css/**").permitAll()
                .antMatchers("/", "/users/register", "/users/login").anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .usernameParameter("user")
                .passwordParameter("asd")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
}
