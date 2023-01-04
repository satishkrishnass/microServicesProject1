package com.myProjects.moviecatalogservice.resources;

import ch.qos.logback.classic.spi.TurboFilterList;
import com.myProjects.moviecatalogservice.models.CatalogItem;
import com.myProjects.moviecatalogservice.models.Movie;
import com.myProjects.moviecatalogservice.models.Rating;
import com.myProjects.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catelog")
public class MovieResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){


        // get all movies with rating from ratingservice. -- >
        UserRatings ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+userId, UserRatings.class);
//        return Collections.singletonList(
//                new CatalogItem("bahubali","prabhas action movie",5)
        return ratings.getUserRatings().stream().map(rating -> {
            // then get those movie id's info from movie info service.
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
            // collect all and send as response.
            return new CatalogItem(movie.getMovieId(),movie.getMovieDesc(),rating.getMovieRating());
        }).collect(Collectors.toList());
//       return ratings.stream().map(rating ->
//               new CatalogItem("bahu","prabhas super moive",4)).collect(Collectors.toList());


//        );


        // below is the webClient way - dependency is webflex.
            /*Movie movie= webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

                    */

    }
}
