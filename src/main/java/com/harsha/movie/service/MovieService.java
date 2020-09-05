package com.harsha.movie.service;

import java.util.List;

import com.harsha.movie.entity.Movie;

public interface MovieService {

	List<Movie> findAllMovies();

	void removeMovie(Long imdb,Integer id);

	Movie saveMovie(Movie movie);

	Movie getMovieByImdbId(Long imdbId);


}
