package sout.config;

import sout.config.security.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by ucha on 3/6/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"."})
public class SpringMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SecurityInterceptor());
	}

	@Bean
	InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

		internalResourceViewResolver.setPrefix("/views/");
		internalResourceViewResolver.setSuffix(".jsp");

		return internalResourceViewResolver;
	}

}