package com.example.issue638;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.content.rest.config.RestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;

@SpringBootApplication
public class Issue638Application {

	public static void main(String[] args) {
		SpringApplication.run(Issue638Application.class, args);
	}

	@Import({RepositoryRestMvcConfiguration.class, RestConfiguration.class})
	public class CustomizedRestMvcConfiguration implements RepositoryRestConfigurer {

	    // this configures Spring Data
        @Override
        public void configureConversionService(ConfigurableConversionService conversionService) {

            conversionService.addConverter(new Converter<String, MediumFileContentJpaId>() {
                @Override
                public MediumFileContentJpaId convert(String source) {
                    String[] segments = source.split("_");
                    return new MediumFileContentJpaId(segments[0], segments[1]);
                }
            });
        }

        // this configures Spring Data REST
	    @Bean
	    public BackendIdConverter converter() {
	        return new BackendIdConverter() {

	            @Override
	            public boolean supports(Class<?> delimiter) {
	                return delimiter.equals(MediumFileContentJpaEntity.class);
	            }

	            @Override
	            public Serializable fromRequestId(String id, Class<?> entityType) {
	                if (id != null) {
	                    MediumFileContentJpaId ptid = new MediumFileContentJpaId();
	                    String[] idParts = id.split("_");
	                    ptid.setMediumId(idParts[0]);
	                    ptid.setFileId(idParts[1]);
	                    return ptid;
	                }
	                return new MediumFileContentJpaId();
	            }

	            @Override
	            public String toRequestId(Serializable id, Class<?> entityType) {
	                if (id instanceof MediumFileContentJpaId) {
	                    MediumFileContentJpaId ptid = (MediumFileContentJpaId) id;
	                    return String.format("%s_%s", ptid.getMediumId(), ptid.getFileId());
	                }
	                return BackendIdConverter.DefaultIdConverter.INSTANCE.toRequestId(id, entityType);
	            }
	        };
	    }
	}
}
