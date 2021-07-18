package com.buraktan.test.dao;

import com.buraktan.app.core.dao.CategoryDao;
import com.buraktan.app.core.dao.MovieDao;
import com.buraktan.app.core.domain.Category;
import com.buraktan.app.core.domain.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
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

        CategoryDao categoryDao = new CategoryDao();
        Category categoryById = categoryDao.findCategoryById(4);

        LocalDate date = LocalDate.of(2007, 12, 14);

        Movie movie = new Movie();
        movie.setName("I Am King 2");
        movie.setRating(7.2);
        movie.setPublishDate(date);
        movie.setCategory(categoryById);

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
        Movie movie = movieDao.findMovieById(1l);
        Assert.assertNotNull(movie);
        System.out.println(movie);
    }

    @Test
    public void findMovieByCategoryIdTest() {

        MovieDao movieDao = new MovieDao();
        List<Movie> movieByCategoryId = movieDao.findMovieByCategoryId(1l);
        for (Movie movie : movieByCategoryId) {
            System.out.println(movie);
        }
    }
}
