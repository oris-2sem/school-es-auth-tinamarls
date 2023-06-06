package com.example.security.config;

import com.example.security.filters.JwtAuthenticationFilter;
import com.example.security.filters.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsServiceImpl;

    private final AuthenticationProvider refreshTokenAuthenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,
                                                   JwtAuthenticationFilter jwtAuthenticationFilter,
                                                   JwtAuthorizationFilter jwtAuthorizationFilter) throws Exception {

        httpSecurity.csrf().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/lesson/**").permitAll()
                .antMatchers(HttpMethod.GET, "/timetable/**").permitAll()
                .antMatchers(HttpMethod.GET, "/parent/**").hasAuthority("PARENT")
                .antMatchers(HttpMethod.GET, "/student/**").hasAuthority("STUDENT")
                .antMatchers(HttpMethod.GET, "/teacher/**").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.GET, "/class/**").authenticated()
                .antMatchers(HttpMethod.GET, "/task/**").authenticated()

                .antMatchers(HttpMethod.PUT, "/lesson/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/lesson/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/lesson/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/student/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/student/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/student/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/teacher/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/teacher/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/teacher/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/class/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/class/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/class/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/timetable/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/timetable/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/timetable/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/parent/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/parent/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/parent/**").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.PUT, "/task/**").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.DELETE, "/task/**").hasAuthority("TEACHER")
                .antMatchers(HttpMethod.POST, "/task/**").hasAuthority("TEACHER")

                .anyRequest().permitAll();

        httpSecurity.logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        httpSecurity.addFilter(jwtAuthenticationFilter);
        httpSecurity.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Autowired
    public void bindUserDetailsServiceAndPasswordEncoder(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(refreshTokenAuthenticationProvider);
        builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }
}

