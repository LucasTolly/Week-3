package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int)session.save(user);
        transaction.commit();
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
    }


    /**
     * Update the user
     * @param user
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }



}
