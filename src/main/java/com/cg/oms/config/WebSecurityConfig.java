package com.cg.oms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthEntryPoint unauthorizedHandler;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		System.out.println("---Web security -- configure");
//		//httpSecurity.cors().disable();
//		// We don't need CSRF for this example
//		httpSecurity.cors().and().csrf().disable()
//				// dont authenticate this particular request
//				.authorizeRequests().antMatchers("/login", "/register").permitAll().
//				// all other requests need to be authenticated
//						anyRequest().authenticated().and().
//				// make sure we use stateless session; session won't be used to
//				// store user's state.
//						exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		// Add a filter to validate the tokens with every request
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// we don't need CSRF because our token is invulnerable
		httpSecurity.csrf().disable()

				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

				// don't create session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

				.authorizeRequests()
				// .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

				// allow anonymous resource requests
				.antMatchers(HttpMethod.GET, "/", "/v2/api-docs", // swagger
						"/webjars/**", // swagger-ui webjars
						"/swagger-resources/**", // swagger-ui resources
						"/configuration/**", // swagger configuration
						"/*.html", "/favicon.ico", "/**/*.html", "/**/*.css", "/**/*.js")
//				.permitAll().antMatchers("/cart/**").permitAll().antMatchers("/mobile/**").permitAll()
//				.antMatchers("/admin/**", "/customer/**", "/order/**", "/authentication/**").permitAll()
//				.antMatchers("/category/**").permitAll().anyRequest().authenticated();
				.permitAll().antMatchers("/authentication/**").permitAll().antMatchers("/category/**").permitAll()
				.anyRequest().authenticated();

// Custom JWT based security filter
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

// disable page caching
		httpSecurity.headers().cacheControl();
		httpSecurity.cors().and().csrf().disable();
	}

}