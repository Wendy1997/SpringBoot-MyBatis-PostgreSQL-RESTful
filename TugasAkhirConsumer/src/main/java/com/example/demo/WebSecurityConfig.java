package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;
	
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/mahasiswa/viewall").hasAnyRole("ADMIN")
		.antMatchers("/mahasiswa/view").hasAnyRole("ADMIN")
		.antMatchers("/mahasiswa/add").hasAnyRole("ADMIN")
		.antMatchers("/mahasiswa/update").hasAnyRole("ADMIN")
		.antMatchers("/mahasiswa/delete").hasAnyRole("ADMIN")
		.antMatchers("/mahasiswa/riwayat").hasRole("USER")
		.antMatchers("/mahasiswa/ringkasan").hasRole("USER")
		.antMatchers("/irs/**").hasRole("USER")
		.and()
		.formLogin().loginPage("/login").permitAll().successHandler(customSuccessHandler)
		.and()
		.csrf()
		.and()
		.logout().permitAll().logoutSuccessUrl("/login");
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
	
	@Component
	public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	 
	    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	 
	    @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	            throws IOException {
	        String targetUrl = determineTargetUrl(authentication);
	 
	        if (response.isCommitted()) {
	            System.out.println("Can't redirect");
	            return;
	        }
	 
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }
	 
	    /*
	     * This method extracts the roles of currently logged-in user and returns
	     * appropriate URL according to his/her role.
	     */
	    protected String determineTargetUrl(Authentication authentication) {
	        String url = "";
	 
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	 
	        List<String> roles = new ArrayList<String>();
	 
	        for (GrantedAuthority a : authorities) {
	            roles.add(a.getAuthority());
	        }
	 
	        if (isAdmin(roles)) {
	            url = "/mahasiswa/viewall";
	        } else if (isUser(roles)) {
	            url = "/mahasiswa";
	        }
	 
	        return url;
	    }
	 
	    private boolean isUser(List<String> roles) {
	        if (roles.contains("ROLE_USER")) {
	            return true;
	        }
	        return false;
	    }
	 
	    private boolean isAdmin(List<String> roles) {
	        if (roles.contains("ROLE_ADMIN")) {
	            return true;
	        }
	        return false;
	    }
	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	 
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }
	 
	}
}
