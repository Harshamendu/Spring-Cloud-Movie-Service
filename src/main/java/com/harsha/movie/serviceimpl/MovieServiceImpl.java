package com.harsha.movie.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.harsha.movie.entity.Movie;
import com.harsha.movie.repo.MovieRepo;
import com.harsha.movie.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepo movieRepo;
	
	@Override
	public List<Movie> findAllMovies() {
		 Iterable<Movie> movieItr = movieRepo.findAll();
		 List<Movie> movieList = new ArrayList<>();
		 movieItr.forEach(s -> movieList.add(s));
		if (CollectionUtils.isEmpty(movieList))
			return null;
		else
			return movieList;
	}

	@Override
	@CacheEvict(value = "Movie", key = "#imdbId")
	public void removeMovie(Long imdbId,Integer id) {
		movieRepo.deleteById(id);
		
	}

	@Override
	@CachePut(value = "Movie", key = "#movie.imdbId")
	public Movie saveMovie(Movie movie) {
		Movie retMovie = movieRepo.saveAndFlush(movie);
		return retMovie;
	}

	@Override
	@Cacheable(value = "Movie", key = "#imdbId", unless = "#result.followers < 12000")
	public Movie getMovieByImdbId(Long imdbId) {
		Optional<Movie> optMovie = movieRepo.findByImdbId(imdbId);
		if(optMovie.isPresent())
			return optMovie.get();
		else 
			return null;
	}

}
