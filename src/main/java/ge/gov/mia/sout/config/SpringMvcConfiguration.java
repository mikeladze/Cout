package ge.gov.mia.sout.config;

import ge.gov.mia.sout.config.security.SecurityInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

}
