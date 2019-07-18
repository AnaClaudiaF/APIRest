package br.com.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rest.service.FileService;

@Configuration
public class FileConfig {
    @Autowired
    private FileService fileService;
    
    @Bean
    public boolean readCsvFile() {
	fileService.readCsvFile();
	
	return true;
    }
}
