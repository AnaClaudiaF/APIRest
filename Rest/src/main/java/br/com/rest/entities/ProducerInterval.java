package br.com.rest.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProducerInterval implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Producers> min;
    private List<Producers> max;
    
    public ProducerInterval() {
	min = new ArrayList<Producers>();
	max = new ArrayList<Producers>();
    }

    public List<Producers> getMax() {
	return max;
    }

    public List<Producers> getMin() {
	return min;
    }

    public void setMin(Producers producers) {
	this.min.add(producers);
    }

    public void setMax(Producers producers) {
	this.max.add(producers);
    }

}
