package com.connected.oauth2jwt.config;


import com.connected.oauth2jwt.domain.security.model.role.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServer extends ResourceServerConfigurerAdapter {

    private final AuthenticationEntryPointImpl unauthorizedHandler;

    @Autowired
    public ResourceServer(final AuthenticationEntryPointImpl unauthorizedHandler) {
        this.unauthorizedHandler = unauthorizedHandler;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // allow anonymous resource requests
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
//                  .antMatchers("/oauth/**").authenticated()
                .antMatchers("/roles/**").hasRole(RoleName.ADMIN.name())
                .antMatchers("/users/**").hasRole(RoleName.ADMIN.name())
                .anyRequest().authenticated();

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}