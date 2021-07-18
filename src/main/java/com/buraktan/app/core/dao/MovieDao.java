package com.buraktan.app.core.dao;

import com.buraktan.app.core.domain.Movie;
import com.buraktan.app.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MovieDao {

    public List<Movie> findAllMovies() {
        List<Movie> movieList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select movie From Movie movie";
            Query query = session.createQuery(hql);
            movieList = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movieList;

    }

    public Movie saveMovie(Movie movie) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            movie = (Movie) session.merge(movie);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movie;
    }

    public void deleteMovie(long id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String qryString = "Delete From Movie m Where m.id=:mId";
            Query query = session.createQuery(qryString);
            query.setParameter("mId", id);
            int count = query.executeUpdate();
            System.out.println(count + " Record(m) Deleted.");

            transaction.commit();
            session.clear();
            session.close();
            System.out.println("Transaction Completed !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Movie> findMovieByName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        List<Movie> movieList = new ArrayList<Movie>();
        try {
            String qryString = "Select movie From Movie movie Where movie.name like concat('%',:mName,'%')";
            Query query = session.createQuery(qryString);
            query.setParameter("mName", name);
            movieList = query.list();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movieList;
    }

    public Movie getMovieDetails(long id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Movie movie = null;
        try {
            String qryString = "Select movie From Movie movie Where movie.id=:mId";
            Query query = session.createQuery(qryString);
            query.setParameter("mId", id);
            movie = (Movie) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movie;
    }

    public List<Movie> findMovieByCategoryId(long id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            String qryString = "Select movie From Movie movie Where movie.category.id=:mId";
            Query query = session.createQuery(qryString);
            query.setParameter("mId", id);
            System.out.println("asjgdiusadhljksaghdasndskdml");
            movieList = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movieList;
    }

}

