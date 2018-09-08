package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //jdbc authentication provider
		/*auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM  USER_ROLES WHERE UNAME=?");*/
		// inMemory Authentication provider
/*		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("ROLE_CUSTOMER")
		.and().withUser("karan").password("{noop}arjun").authorities("ROLE_MANAGER");
*/
		
		auth
		.ldapAuthentication()
			.userDnPatterns("uid={0},ou=users")
			.groupSearchBase("ou=groups")
			.contextSource()
				.url("ldap://localhost:10389/o=nit").managerDn("uid=admin,ou=system").managerPassword("secret")
				.and()
			.passwordCompare()
				.passwordAttribute("userPassword");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll")
		.antMatchers("/getBal.htm").access("hasAnyRole('ROLE_MANAGER','ROLE_CUSTOMER')").and()
		.formLogin().
		and().
		exceptionHandling().accessDeniedPage("/access_fail.htm")
		.and()
		.logout().logoutSuccessUrl("/logout.htm").logoutUrl("/performLogout")
		.and().csrf().disable();
	}
	
}
