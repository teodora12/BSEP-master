package com.ftn.agent.config;

import com.ftn.agent.restService.restServiceImpl.CustomUserDetailsService;
import com.ftn.agent.security.TokenUtils;
import com.ftn.agent.security.auth.RestAuthenticationEntryPoint;
import com.ftn.agent.security.auth.TokenAuthenticationFilter;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    private static final Argon2 ARGON2 = Argon2Factory.create();

    private static final int ITERATIONS = 2;
    private static final int MEMORY= 65536;
    private static final int PARALLELISM = 1;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                final String hash = ARGON2.hash(ITERATIONS, MEMORY, PARALLELISM, charSequence.toString());
                return hash;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return ARGON2.verify(s, charSequence.toString());
            }
        };
    }


    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;   //sadrzi metodu loadByUsername

    // Neautorizovani pristup zastcenim resursima
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    TokenUtils tokenUtils;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // komunikacija izmedju klijenta i servera je stateless
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                // za neautorizovane zahteve posalji 401 gresku
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()


                .authorizeRequests()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/accommodation/search").permitAll()
        //        .antMatchers("/api/accommodation/agent/**").permitAll()
                .and();

        // presretni svaki zahtev filterom
        http.addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService), BasicAuthenticationFilter.class);
        http.headers().contentSecurityPolicy("script-src 'self' https://trustedscripts.example.com; object-src https://trustedplugins.example.com; report-uri /csp-report-endpoint/");

        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // TokenAuthenticationFilter ce ignorisati sve ispod navedene putanje

        web.ignoring().antMatchers(HttpMethod.POST, "/api/auth/login");
        web.ignoring().antMatchers(HttpMethod.POST, "/api/user/register");
//        web.ignoring().antMatchers(HttpMethod.POST, "/api/room/create");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/accommodation/**");
//        web.ignoring().antMatchers(HttpMethod.POST, "/api/reservation/create");
//        web.ignoring().antMatchers(HttpMethod.PUT, "/api/reservation/confirm/**");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/accommodation/agent/**");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/reservation/agent/**");
//        web.ignoring().antMatchers(HttpMethod.PUT, "/api/room/update");
//        web.ignoring().antMatchers(HttpMethod.DELETE, "/api/room/delete/**");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/agent/**");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/message/all/**");
//        web.ignoring().antMatchers(HttpMethod.POST, "/api/message/create");
//        web.ignoring().antMatchers(HttpMethod.GET, "/api/accommodation");









    }


}
