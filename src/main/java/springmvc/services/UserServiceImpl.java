package springmvc.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.dao.AddressDAO;
import springmvc.dao.UserDAO;
import springmvc.model.Address;
import springmvc.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private UserService userService;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public int registerUser(User user) {
        List<Address> addresses = user.getAddresses();
        for (Address e: addresses
             ) {
            System.out.println(e.getSelectCity());
        }
        if (addresses != null) {
            for (Address address : addresses) {
                address.setUser(user);
                System.out.println(address);
            }
        }
        user.setAddresses(addresses);
        return this.userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    @Transactional
    public List<Address> getUserAddresses(int userId) {
        return addressDAO.getUserAddresses(userId);
    }

    public void updateAddress(Address address) {
        this.addressDAO.updateAddress(address);
    }

    public void deleteAddress(Address address) {
        this.addressDAO.deleteAddress(address);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.update(user);
    }


    @Override
    public User getUserById(int id) {
       return this.userDAO.getById(id);
    }

    public List<User> getAllUsers() {
        return this.userDAO.getAll();
    }

    public void deleteUser(User user) {
        this.userDAO.delete(user);
    }

    @Transactional
    public boolean isEmailAlreadyRegistered(String email) {
         User existingUser = userDAO.getUserByEmail(email);
         return existingUser!=null;
    }

    @Transactional
    public boolean isUsernameAlreadyRegistered(String username){
        User existingUser = userDAO.getByUsername(username);
        return existingUser!= null;
    }

    public void updateUserPassword(String email, String encodedPassword) {

        this.userDAO.updateUserPassword(email,encodedPassword);
    }


    @Override
    public void updateAddressesAndUser(User user, HttpServletRequest req) {

        String[] street = req.getParameterValues("streetAddress");
        String[] apartmentNumber = req.getParameterValues("apartmentNumber");
        String[] zipCode = req.getParameterValues("zipCode");
        String[] city = req.getParameterValues("city");
        String[] state = req.getParameterValues("state");
        String[] addressid = req.getParameterValues("addressId");
        List<Address> addressList = new ArrayList<>();

        for (int i = 0; i < street.length; i++) {
            Address address = new Address();

            if (addressid[i] != null && !addressid[i].isEmpty()) {
                address.setAddressId(Integer.parseInt(addressid[i]));
            }

            address.setAddress1(street[i]);
            address.setApartment1(apartmentNumber[i]);
            address.setZipcode1(zipCode[i]);
            address.setSelectCity(city[i]);
            address.setSelectState(state[i]);
            address.setUser(user);

            if (addressid[i] == null || addressid[i].equals("")) {
                addressList.add(address);
            } else {
                this.userService.updateAddress(address);
            }
        }

        List<Address> addresses = this.userService.getUserAddresses(user.getUserId());
        int index = 0;
        int[] oldAddressid = new int[addresses.size()];
        int addressIdLength = addressid.length;
        int count = 0;

        for (Address address : addresses) {
            oldAddressid[index] = address.getAddressId();
            if (count < addressIdLength && addressid[count].length() != 0) {
                int addrssid = Integer.parseInt(addressid[count]);
                if (oldAddressid[index] == addrssid) {
                    count++;
                } else {
                    this.userService.deleteAddress(address);
                }
            } else {
                this.userService.deleteAddress(address);
            }
            index++;
        }

        user.setAddresses(addressList);
        this.userService.updateUser(user);
    }
//    @Override
//    public void sendOtpByEmail(String email) throws MessagingException {
//        Random rand = new Random();
//        int otpValue = rand.nextInt(1255650);
//
//        // Rest of the code for sending email
//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
//
//        Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("panchaldeep113@gmail.com", "ugbimjuhqkxbcopr");
//            }
//        });
//
//        MimeMessage messageObject = new MimeMessage(mailSession);
//        messageObject.setFrom(new InternetAddress("panchaldeep113@gmail.com")); // Set your email here
//        messageObject.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//        messageObject.setSubject("Hello");
//        messageObject.setText("Your OTP is: " + otpValue);
//        Transport.send(messageObject);
//    }

}
