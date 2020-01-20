package com.galaxy.carinfoservice.resources;

import com.galaxy.carinfoservice.models.Car;
import com.galaxy.carinfoservice.models.CarSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cars")
public class CarResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{carId}")
    public Car getCarInfo(@PathVariable("carId") String carId) {
        CarSummary carSummary = restTemplate.getForObject("https://api.thecardb.org/3/car/" + carId + "?api_key=" +  apiKey, CarSummary.class);
        return new Car(carId, carSummary.getTitle(), carSummary.getOverview());
    }

}
