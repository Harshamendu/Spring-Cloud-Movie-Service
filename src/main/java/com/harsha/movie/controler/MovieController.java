package com.harsha.movie.controler;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harsha.movie.entity.Movie;
import com.harsha.movie.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieService;

	@GetMapping("/getMovies")
	public @ResponseBody ResponseEntity<List<Movie>> findAllMovies() {
		System.out.println(" ****** From server 1 ********");
		List<Movie> MovieList = movieService.findAllMovies();
		return new ResponseEntity<List<Movie>>(MovieList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{imdbId}", method = RequestMethod.GET)
	public @ResponseBody Movie getMovie(@PathVariable Long imdbId) {
		Movie movie = movieService.getMovieByImdbId(imdbId);
		return movie;
//	  return new ResponseEntity<Movie>(Movie,HttpStatus.OK);
	}

	@PostMapping(value = "/addMovies", produces = MediaType.APPLICATION_JSON)
	public @ResponseBody Movie addMovie(@RequestBody Movie movie) {
		System.out.println(" ****** From server 1 ********");
		Movie savedMovie = movieService.saveMovie(movie);
		return savedMovie;
//		 return new ResponseEntity<Movie>(savedMovie,HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{imdbId}")
	public ResponseEntity<?> deleteUserByID(@PathVariable Long imdbId) {
		System.out.println("****** From server 1 ********");
		Movie movie = movieService.getMovieByImdbId(imdbId);
		movieService.removeMovie(imdbId,movie.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CacheEvict(value = "Movie", allEntries = true)
	@DeleteMapping("/evict")
	public ResponseEntity<?> clearCache() {
		return null;
	}
}
