package com.we2foodie.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.we2foodie.web.service.CustomUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class DefaultLoginConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		
		
		      .authorizeRequests()
		      .antMatchers("/","/index.html","/login**","/js/**","/css/**","/images/**","/fonts/**","/about**","/menu**","/register**").permitAll()
		      .antMatchers("/register_save**").permitAll()
		      .antMatchers("/inbox**","/logout**").hasAnyRole("ADMIN","NORMAL")
		      .antMatchers("/manageWebContent**").hasRole("ADMIN")
		      .anyRequest()
		      .authenticated()
		      .and()
		      .formLogin()
		      .loginPage("/login").usernameParameter("email")
		      .loginProcessingUrl("/dologin")
		      .defaultSuccessUrl("/inbox")
		      .and().rememberMe()
		      .and()
		      .logout()
		      .logoutUrl("/logout").
		      logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET")).clearAuthentication(true).invalidateHttpSession(true)
		      .logoutSuccessUrl("/login?logout")
		      .deleteCookies("remember-me");
	
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("Nilesh").password(this.passwordEncoder().encode("Nilesh")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("Yogesh").password(this.passwordEncoder().encode("Yogesh")).roles("ADMIN");
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		//this.passwordEncoder().encode("Nilesh@123");
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
		
	}

	
}
