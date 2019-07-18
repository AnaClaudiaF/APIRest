package br.com.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rest.entities.Movie;
import br.com.rest.entities.ProducerInterval;
import br.com.rest.entities.Producers;
import br.com.rest.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public ProducerInterval getMovieInterval() {
	List<Object> resultProducers = movieRepository.findProducers();
	List<Producers> listProducers = new ArrayList<Producers>();

	if (resultProducers.isEmpty()) {
	    throw new ObjectNotFoundException(getClass(), "Producers not found!");
	}

	resultProducers.forEach(object -> {
	    Object[] arrayObject = (Object[]) object;
	    int interval = 0;
	    Producers producer = null;

	    Optional<Producers> optional = listProducers.stream()
		    .filter(p -> p.getProducer().equals(arrayObject[0].toString())).findAny();

	    if (optional.isPresent()) {
		interval = Integer.parseInt(arrayObject[1].toString()) - optional.get().getPreviousWin();
		optional.get().setInterval(interval);
		optional.get().setFollowingWin(new Integer(arrayObject[1].toString()));
	    } else {
		producer = new Producers();
		producer.setProducer(arrayObject[0].toString());
		producer.setPreviousWin(new Integer(arrayObject[1].toString()));
		listProducers.add(producer);
	    }
	});

	ProducerInterval producerMinMax = new ProducerInterval();
	producerMinMax.setMin(listProducers.stream().min((x, y) -> x.getInterval().compareTo(y.getInterval())).get());
	producerMinMax.setMax(listProducers.stream().max((x, y) -> x.getInterval().compareTo(y.getInterval())).get());

	return producerMinMax;
    }

    public List<Movie> getMovieByYear(Integer year) {
	
	List<Movie> resultMovie = movieRepository.findMovieByYearAndWinnerIsNotNull(year);
	
	if (resultMovie.isEmpty()) {
	    throw new ObjectNotFoundException(getClass(), "Movies not found!");
	}
	
	return resultMovie;
    }

}
