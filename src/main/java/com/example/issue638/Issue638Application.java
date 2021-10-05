package com.example.issue638;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
public class Issue638Application {

	public static void main(String[] args) {
		SpringApplication.run(Issue638Application.class, args);
	}

	@Import(RepositoryRestMvcConfiguration.class)
	public class CustomizedRestMvcConfiguration implements RepositoryRestConfigurer {

	    @Bean
	    public MediumFileContentJpaIdConverter converter() {
	        return new MediumFileContentJpaIdConverter();
	    }


//	    @Override
//	    public void configureConversionService(ConfigurableConversionService conversionService) {
//	        conversionService.addConverter(new MediumFileContentJpaIdConverter());
//	    }
	}
}
