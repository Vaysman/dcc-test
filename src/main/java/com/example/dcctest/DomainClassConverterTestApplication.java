package com.example.dcctest;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DomainClassConverterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainClassConverterTestApplication.class, args);
    }

    @Bean
    CommandLineRunner initialize(ModelRepository modelRepository) {
        return args -> {
            Stream.of("Model 1", "Model 2", "Model Ч").forEach(name -> {
                Model model = new Model();
                model.setName(name);
                modelRepository.save(model);
            });
        };
    }
}

@RestController
class ModelController {
    private final ModelRepository repository;

    public ModelController(ModelRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/models/{id}")
    public Model getModel(@PathVariable("id") Model model) {
        return model;
    }

    @GetMapping("/models")
    public Page<Model> findAllModels(Pageable pageable) {
        return repository.findAll(pageable);
    }
}