package ua.kiev.prog.retrievers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.json.Rate;

@Component
public class RateRetriever {

    private static final String URL =
            "http://data.fixer.io/api/latest?access_key=6e79c84ce1ec5188c9272159d6d68a86";

    @Cacheable("rates") // Redis
    public Rate getRate() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Rate> response = restTemplate.getForEntity(URL, Rate.class);
            return response.getBody();
        } catch (Exception ex) {
            return new Rate();
        }
    }
}
