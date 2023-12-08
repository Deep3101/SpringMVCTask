package springmvc.dao;

import org.springframework.stereotype.Repository;
import springmvc.model.Address;
import springmvc.model.User;

import java.util.List;

@Repository
public interface UserDAO {

    int saveUser(User user);

    String getUserRole(String username);

    int authenticateUserAndGetId(String username, String password);

    User getUserByUsername(String username);

    void update(User user);

    User getById(int id);

    List<User> getAll();

     void delete(User user);

    int checkEmailExistence(String email);

    boolean updateUserPassword(String email, String encodedPassword);

    User getUserByEmail(String email);

    User getByUsername(String username);

}
