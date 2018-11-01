package learn.springboot.config.documentation;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:/properties/documentation/swagger.properties")
public class SwaggerConfiguration {
	
	private Environment env;
	
	@Autowired
	public SwaggerConfiguration(Environment env) {
		this.env = env;
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
		
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       env.getProperty("swagger.doc.title"), 
	       env.getProperty("swagger.doc.subtitle"), 
	       env.getProperty("swagger.doc.tos"), 
	       env.getProperty("swagger.doc.terms.and.conditions"), 
	       new Contact(env.getProperty("swagger.doc.contact.name"), env.getProperty("swagger.doc.contact.uri"), env.getProperty("swagger.doc.contact.emailid")), 
	       env.getProperty("swagger.doc.license.api"), env.getProperty("swagger.doc.license.uri"), Collections.emptyList());
	}

}
