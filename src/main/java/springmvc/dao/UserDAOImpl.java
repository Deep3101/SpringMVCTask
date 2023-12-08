package springmvc.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.User;

import javax.persistence.NoResultException;
import java.util.Base64;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int saveUser(User user) {
        String plainPassword = user.getPassword();

        // pwd encoded
        String encodedPassword = Base64.getEncoder().encodeToString(plainPassword.getBytes());

        user.setPassword(encodedPassword);
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return 0;
    }

    public String getUserRole(String username) {
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery("SELECT role FROM User WHERE userName = :username", String.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int authenticateUserAndGetId(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE userName = :username", User.class);
            query.setParameter("username", username);
            User user = query.uniqueResult();

            if (user != null) {
                // Assuming the stored password is encoded using Base64, you need to decode it
                String storedEncodedPwd = user.getPassword();
                String decodedPassword = new String(Base64.getDecoder().decode(storedEncodedPwd));

                if (decodedPassword.equals(password)) {
                    return user.getUserId();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User WHERE userName = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM User";
            return session.createQuery(hql, User.class).list();
        } finally {
            session.close();
        }
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public int checkEmailExistence(String emailAddress) {
        try {
            Long count = (Long) sessionFactory.getCurrentSession()
                    .createQuery("SELECT COUNT(*) FROM User WHERE email = :emailAddress")
                    .setParameter("emailAddress", emailAddress)
                    .uniqueResult();

            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateUserPassword(String email, String encodedPassword) {
        String hql = "UPDATE User SET password = :newPassword WHERE email = :email";

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery(hql)
                    .setParameter("newPassword", encodedPassword)
                    .setParameter("email", email)
                    .executeUpdate();

            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User u WHERE u.emailAddress = :email";

        try {
            return session.createQuery(hql, User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User getByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM User u WHERE u.userName = :username";

        try {
            return session.createQuery(hql, User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
