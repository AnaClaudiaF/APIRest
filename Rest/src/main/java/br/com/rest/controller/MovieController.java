package br.com.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rest.dto.MovieDto;
import br.com.rest.dto.ProducersDto;
import br.com.rest.entities.Movie;
import br.com.rest.entities.ProducerInterval;
import br.com.rest.service.MovieService;

@RestController
@RequestMapping(value = "piorFilme")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController() {
    }

    @RequestMapping(path = "/intervalo-premios", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieInterval() {
	ProducerInterval producerInterval = movieService.getMovieInterval();

	ProducersDto producerDto = new ProducersDto(producerInterval);

	return ResponseEntity.ok().body(producerDto);
    }

    @RequestMapping(path = "/vencedor/{ano}", method = RequestMethod.GET)
    public ResponseEntity<?> getMovieByYear(@PathVariable Integer ano) {
	List<Movie> result_movie = movieService.getMovieByYear(ano);
	List<MovieDto> movie_dto = new ArrayList<MovieDto>();

	result_movie.forEach(m -> {
	    movie_dto.add(new MovieDto(m));
	});

	return (ResponseEntity.ok().body(movie_dto));
    }
}