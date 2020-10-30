package com.gursu.springsecuritydemo.rest;

import com.gursu.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    private final List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Jack", "Sparrow"),
            new Developer(2L, "William", "Smith"),
            new Developer(3L, "Tim", "Walker")
    ).collect(Collectors.toList());


    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{developerId}")
    public Developer getById(@PathVariable Long developerId){
        return DEVELOPERS.stream()
                         .filter(developer -> developer.getId().equals(developerId))
                         .findFirst()
                         .orElseThrow(()-> new RuntimeException("Developer with ID: " + developerId + " not found!"));
    }
}
