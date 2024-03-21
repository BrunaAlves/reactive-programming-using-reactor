package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService =
            new FluxAndMonoGeneratorService();


    @Test
    void namesFlux() {
        //given

        //when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        //then
        StepVerifier.create(namesFlux)
               // .expectNext("alex", "ben", "chloe")//It will receive the elements in order
              //  .expectNextCount(3) //Total number of elements
                .expectNext("alex")// You can combine with the next function. First we have alex and 2 more elements
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void namesMono() {
        //given

        //when
        var namesMono = fluxAndMonoGeneratorService.namesMono();

        //then
        StepVerifier.create(namesMono)
                .expectNext("alex")
                .verifyComplete();
    }
}
