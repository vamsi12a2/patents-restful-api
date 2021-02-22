package com.springpro.rest.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.springpro.rest.services.PatentUserDetailsService;

@Configuration
@PropertySource("classpath:database.cfg")
public class DBConfiguration {
	
	@Value("${url}")
	private String url;
	@Value("${driver}")
	private String driver;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean("mySQLDS")
	@Primary
	public DataSource getDataSource() {
		DataSourceBuilder<?> dsBuilder= DataSourceBuilder.create();
		dsBuilder.url(url);
		dsBuilder.driverClassName(driver);
		dsBuilder.username(username);
		dsBuilder.password(password); 
		return dsBuilder.build();
	}
	
	@Bean
	public UserDetailsService patentDetailsService() {
		return new PatentUserDetailsService();
	}
}
