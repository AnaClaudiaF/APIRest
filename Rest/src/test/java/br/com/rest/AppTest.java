package br.com.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.hibernate.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.rest.controller.MovieController;

public class AppTest extends AppTestAbstract {
    @Autowired
    private MovieController movieController;
    
    @Override
    @Before
    public void setUp() {
       super.setUp();
    }
    @Test
    public void getMinMaxInterval() throws Exception {
       String uri = "/piorFilme/intervalo-premios";
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
       String content = mvcResult.getResponse().getContentAsString();
//       ProducerInterval[] producers = super.mapFromJson(content, ProducerInterval[].class);
       assertTrue(content.length() > 0);
System.out.println(content);
    }
    
    @Test
    public void findProducersMinMaxInterval() {
        ResponseEntity<?> response = movieController.getMovieInterval();
        Assert.assertThat(HttpStatus.OK, Matchers.is(response.getStatusCode()));
    }
    
    @Test
    public void findProducersByYear() {
        ResponseEntity<?> response = movieController.getMovieByYear(2014);
        Assert.assertThat(HttpStatus.OK, Matchers.is(response.getStatusCode()));
    }

    @Test(expected = ObjectNotFoundException.class)
    public void findProducersYearNotFound() {
        ResponseEntity<?> response = movieController.getMovieByYear(1900);
        Assert.assertThat(HttpStatus.NOT_FOUND, Matchers.is(response.getStatusCode()));
    }
 }