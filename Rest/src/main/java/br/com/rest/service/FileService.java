package br.com.rest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.entities.Movie;
import br.com.rest.repository.MovieRepository;

@Service
public class FileService {
    @Autowired
    MovieRepository movieRepository;
    
    public FileService() {}

    public void readCsvFile() {
	try {
	    List<Movie> list_movie = Files.lines(Paths.get("src/main/resource/movielist.csv"))
	    	.skip(1)
	    	.map(line -> line.split(";"))
	    	.map(columns -> {
	    	    Movie movie = new Movie();
	    	    movie.setYear(new Integer(columns[0]));
	    	    movie.setTitle(columns[1]);
	    	    
	    	    String[] studios = columns[2].split(",");
	    	    
	    	    movie.setStudios(
	    		    Arrays.asList(studios)
	    		    .stream()
	    		    .map(studio -> studio.trim()).collect(Collectors.toSet())
	    	    );
	    	    
	    	    String[] producers = columns[3].split(",|\\sand\\s|and\\s");
	    	    
	    	    movie.setProducers(
	    		    Arrays.asList(producers)
	    		    .stream()
	    		    .map(producer -> producer.trim()).collect(Collectors.toSet())
	    	    );
	    	    
	    	    if (columns.length == 5) {
	    		movie.setWinner(columns[4]);
	    	    }
	    	    
	    	    return movie;
	    	}).collect(Collectors.toList());
	    
	    movieRepository.saveAll(list_movie);
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
