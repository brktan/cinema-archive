package com.buraktan.app.core.dao;


import com.buraktan.app.core.domain.Category;
import com.buraktan.app.core.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {
    public List<Category> findAllCategories() {
        List<Category> categoryList = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select category From Category category";
            Query query = session.createQuery(hql);
            categoryList = query.list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoryList;

    }

    public Category saveCategory(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            category = (Category) session.merge(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public void deleteCategory(long cId) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String qryString = "delete from Category c where c.id=:cId";
            Query query = session.createQuery(qryString);
            query.setParameter("cId", cId);
            int count = query.executeUpdate();
            System.out.println(count + " Record(c) Deleted.");

            transaction.commit();
            session.clear();
            session.close();
            System.out.println("Transaction Completed !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Category findCategoryById(long id) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Category category = null;
        try {
            String qryString = "Select category From Category category Where category.id=:cId";
            Query query = session.createQuery(qryString);
            query.setParameter("cId", id);
            category = (Category) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }
}
