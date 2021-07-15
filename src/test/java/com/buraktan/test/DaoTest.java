package com.buraktan.test;

import com.buraktan.app.core.dao.CategoryDao;
import com.buraktan.app.core.dao.MovieDao;
import com.buraktan.app.core.domain.Category;
import com.buraktan.app.core.domain.Movie;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class DaoTest {

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
        movie.setName("Dark Knight");
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
    public void findAllCategoriesTest() {

        List<Category> categoryList;

        MovieDao movieDao = new MovieDao();
        CategoryDao categoryDao = new CategoryDao();
        categoryList = categoryDao.findAllCategories();

        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    @Test
    public void saveCategoryTest() {

        Category category = new Category();
        category.setName("Comedy");

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.saveCategory(category);
    }

    @Test
    public void deleteCategoryTest() {

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteCategory(7L);
    }
}
