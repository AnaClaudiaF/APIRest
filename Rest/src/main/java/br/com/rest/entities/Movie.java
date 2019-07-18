package br.com.rest.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = 3747987198726794494L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "title", nullable = false)
    private String title;

    @ElementCollection
    @CollectionTable(name = "studios")
    private Set<String> studios = new HashSet<String>();

    @ElementCollection
    @CollectionTable(name = "producers")
    private Set<String> producers = new HashSet<String>();

    @Column(name = "winner", nullable = true)
    private String winner;

    public Movie() {
    }

    public Movie(Long id, Integer year, String title, Set<String> studios, Set<String> producers, String winner) {
	this.id = id;
	this.year = year;
	this.title = title;
	this.studios = studios;
	this.producers = producers;
	this.winner = winner;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
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

    public String getWinner() {
	return winner;
    }

    public void setWinner(String winner) {
	this.winner = winner;
    }

    @Override
    public String toString() {
	return (getClass().getName() + "[id=" + id + ", year=" + year + ", title=" + title + ", studios=" + studios
		+ ", producers=" + producers + ", winner=" + winner + "]");
    }
}