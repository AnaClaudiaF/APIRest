package br.com.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.rest.entities.ProducerInterval;
import br.com.rest.entities.Producers;

public class ProducersDto {

    @JsonProperty("min")
    private List<Producers> min;

    @JsonProperty("max")
    private List<Producers> max;

    public ProducersDto(ProducerInterval intervalo) {
	this.max = intervalo.getMax();
	this.min = intervalo.getMin();
    }

    public List<Producers> getMin() {
	return min;
    }

    public List<Producers> getMax() {
	return max;
    }
}
