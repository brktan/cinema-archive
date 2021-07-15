package com.buraktan.test.dao;

import com.buraktan.app.core.dao.MovieDao;
import com.buraktan.app.core.domain.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MovieDaoTest {

    @Test
    public void findAllMoviesTest() {

        List<Movie> movieList;

        MovieDao movieDao = new MovieDao();
        movieList = movieDao.findAllMovies();

        for (Movie movie : movieList) {
            System.out.println(movie);
        }

    }

    @Test
    public void saveMovieTest() {

        Date date = new Date();
        date.setYear(2008);

        Movie movie = new Movie();
        movie.setName("Saw IV");
        movie.setRating(8.8);
        movie.setPublishDate(date);

        MovieDao movieDao = new MovieDao();
        movieDao.saveMovie(movie);
    }

    @Test
    public void deleteMovieTest() {

        MovieDao movieDao = new MovieDao();
        movieDao.deleteMovie(2L);

    }

    @Test
    public void findMovieByIdTest() {

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.findMovieById(3l);
        Assert.assertNotNull(movie);
        System.out.println(movie);
    }

}
