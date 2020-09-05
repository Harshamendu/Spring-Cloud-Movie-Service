package com.harsha.movie.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.movie.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer>{

	Optional<Movie> findByImdbId(Long imdbId);

}
