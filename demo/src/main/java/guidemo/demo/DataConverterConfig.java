package guidemo.demo;

import java.text.DateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import guidemo.demo.common.rest.JsonDateFormat;

//@Configuration
public class DataConverterConfig {
	@Autowired
	private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;
	
	@Bean
	public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {
 
		ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
 
		DateFormat dateFormat = mapper.getDateFormat();
		mapper.setDateFormat(new JsonDateFormat(dateFormat));
 
		MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(mapper);
		return mappingJsonpHttpMessageConverter;
	}

}
