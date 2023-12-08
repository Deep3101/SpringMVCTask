package springmvc.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springmvc.model.Address;
import springmvc.model.User;

import javax.mail.MessagingException;
import java.util.List;

@Service
public interface UserService {
    int registerUser(User user);

    User getUserByUsername(String username);

    List<Address> getUserAddresses(int userId);

    void updateAddress(Address address);

    public void deleteAddress(Address address);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    void deleteUser(User user);

    boolean isEmailAlreadyRegistered(String email);

    boolean isUsernameAlreadyRegistered(String username);

    void updateUserPassword(String email, String encodedPassword);

    void updateAddressesAndUser(User user, HttpServletRequest req);


}
