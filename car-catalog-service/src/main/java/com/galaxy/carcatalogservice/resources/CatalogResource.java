package com.galaxy.carcatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.galaxy.carcatalogservice.models.CatalogItem;
import com.galaxy.carcatalogservice.models.Car;
import com.galaxy.carcatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Car car = restTemplate.getForObject("http://car-info-service/cars/" + rating.getCarId(), Car.class);
                    return new CatalogItem(car.getName(), car.getDescription(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}

/*
Alternative WebClient way
Car car = webClientBuilder.build().get().uri("http://localhost:8082/cars/"+ rating.getCarId())
.retrieve().bodyToMono(Car.class).block();
*/