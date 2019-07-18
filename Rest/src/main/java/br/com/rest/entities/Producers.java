package br.com.rest.entities;

import java.io.Serializable;

public class Producers implements Serializable {
    private static final long serialVersionUID = -807533234027744489L;
    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

    public Producers(String producer, Integer interval, Integer previousWin, Integer followingWin) {
	this.producer = producer;
	this.interval = interval;
	this.previousWin = previousWin;
	this.followingWin = followingWin;
    }

    public Producers() {

    }

    public String getProducer() {
	return producer;
    }

    public void setProducer(String producer) {
	this.producer = producer;
    }

    public Integer getPreviousWin() {
	return previousWin;
    }

    public void setPreviousWin(Integer previousWin) {
	this.previousWin = previousWin;
    }

    public Integer getFollowingWin() {
	return followingWin;
    }

    public void setFollowingWin(Integer followingWin) {
	this.followingWin = followingWin;
    }

    public Integer getInterval() {
	return interval;
    }

    public void setInterval(Integer interval) {
	this.interval = interval;
    }

    @Override
    public String toString() {
	return "[producer=" + producer + ", previousWin=" + previousWin + ", followingWin=" + followingWin
		+ ", interval=" + interval + "]";
    }
}
