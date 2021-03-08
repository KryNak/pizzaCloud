package rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rest.model.Concurrences;
import rest.model.Concurrency;

import java.util.List;

@RestController
@RequestMapping(path = "/concurrency")
public class ConcurrencyController {

    private RestTemplate restTemplate;

    public ConcurrencyController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/{symbol}")
    public Concurrency getConcurrency(@PathVariable String symbol){
        return restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base={symbol}&symbols=PLN", Concurrency.class, symbol);
    }

    @GetMapping(path = "/all")
    public Concurrences getAllConcurrences(){
        return restTemplate.getForObject("https://api.exchangeratesapi.io/latest", Concurrences.class);
    }

}
