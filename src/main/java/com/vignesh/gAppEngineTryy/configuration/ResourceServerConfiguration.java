package com.vignesh.gAppEngineTryy.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@EnableResourceServer
@EnableWebSecurity 
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    
    // all requests are filterd from here based on the roles
    @Override
    public void configure(HttpSecurity http) throws Exception {
        
        http
         .authorizeRequests()
         .antMatchers(HttpMethod.POST,"/**").hasAnyAuthority("ROLE_ADMIN,ROLE_MANAGER")
         .antMatchers(HttpMethod.GET,"/**").hasAnyAuthority("ROLE_ADMIN,ROLE_MANAGER,ROLE_USER") 
         .anyRequest().authenticated() 
         .and()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  

} 
}

