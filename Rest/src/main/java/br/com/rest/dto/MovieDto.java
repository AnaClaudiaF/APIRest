package br.com.rest.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.rest.entities.Movie;

public class MovieDto implements Serializable {
    private static final long serialVersionUID = 216920401852394804L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("year")
    private int year;

    @JsonProperty("title")
    private String title;

    @JsonProperty("studios")
    private Set<String> studios;

    @JsonProperty("producers")
    private Set<String> producers;

    @JsonProperty("winner")
    private String winner;

    public MovieDto() {
    }

    public MovieDto(Movie movie) {
	this.id = movie.getId();
	this.year = movie.getYear();
	this.title = movie.getTitle();
	this.studios = movie.getStudios();
	this.producers = movie.getProducers();
	this.winner = movie.getWinner();
    }

    public int getYear() {
	return year;
    }

    public void setYear(int year) {
	this.year = year;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Set<String> getStudios() {
	return studios;
    }

    public void setStudios(Set<String> studios) {
	this.studios = studios;
    }

    public Set<String> getProducers() {
	return producers;
    }

    public void setProducers(Set<String> producers) {
	this.producers = producers;
    }

    public String Winner() {
	return winner;
    }

    public void setWinner(String winner) {
	this.winner = winner;
    }

    public Long getId() {
	return id;
    }

    @Override
    public String toString() {
	return (getClass().getName() + "[id=" + id + ", year=" + year + ", title=" + title + ", studios=" + studios
		+ ", producers=" + producers + ", winner=" + winner + "]");
    }
}
