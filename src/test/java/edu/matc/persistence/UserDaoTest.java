package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.time.Month;
import java.util.List;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created on 9/13/16.
 *
 * @author pwaite
 */
public class UserDaoTest {

    UserDao dao;

    @Before
    public void setup() {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        User testUser = dao.getUser(1);
        assertEquals("Joe", testUser.getFirstName());
    }

    @Test
    public void addUser() throws Exception {
        LocalDate testDate = LocalDate.of(1995, Month.FEBRUARY, 2);
        User testUser = new User(7, "Lucas", "Tolly", testDate);
        dao.addUser(testUser);
        List<User> users = dao.getAllUsers();
        assertEquals(7, users.size());
    }

    @Test
    public void updateUser() throws Exception {
        User testUser = dao.getUser(7);
        testUser.setFirstName("Lukas");;
        dao.updateUser(testUser);
        User updatedUser = dao.getUser(7);
        assertEquals("Lukas", updatedUser.getFirstName());
    }

    @Test
    public void deleteUser() throws Exception {
        dao.deleteUser(7);
        List<User> users = dao.getAllUsers();
        assertEquals(6, users.size());
    }
}