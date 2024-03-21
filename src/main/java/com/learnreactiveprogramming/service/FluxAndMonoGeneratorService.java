package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> namesFlux(){ //Deal with multiple elements, it's a publisher
        return Flux.fromIterable(List.of("alex", "ben", "chloe")).log(); //db or a remote service call
    }

    public Mono<String> namesMono(){ //Deal with one element, infinite number of element... It's a publisher
        return Mono.just("alex").log();
    }

    public static void main(String[] args){
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();
//        fluxAndMonoGeneratorService.namesFlux()
//                .subscribe(name -> System.out.println(name)); //All elelemts in the flux will be sent in the form of stream one by one

        fluxAndMonoGeneratorService.namesMono()
                .subscribe(name -> System.out.println(name));
    }
}