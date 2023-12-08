package springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springmvc.dao.AddressDAO;
import springmvc.dao.UserDAO;
import springmvc.model.Address;
import springmvc.model.User;
import springmvc.services.UserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import jakarta.servlet.http.HttpSession;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import springmvc.utility.UserValidator;

import java.util.*;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AddressDAO addressDAO;



    @RequestMapping(value = {"/", "/welcome"})
    public String home(Model model, HttpSession session) {
        System.out.println("Controller is Working....");
        return "welcome";
    }

    @RequestMapping(path = "register", method = {RequestMethod.GET, RequestMethod.POST})
    public String register() {
        System.out.println("Inside Register.....");

        return "register";
    }


    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }


    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String login(@RequestParam  String username,
                        @RequestParam  String password,
                        HttpSession session,
                        Model model) {

        int userId = userDAO.authenticateUserAndGetId(username, password);

        if (userId > 0) {
            String role = userDAO.getUserRole(username);
            session.setAttribute("username", username);
            session.setAttribute("role", role);
            session.setAttribute("userId", userId);
            session.setAttribute("loggedInUser", username);
            session.setAttribute("loggedIn", true); // Add this line to set the loggedIn attribute


            if ("ADMIN".equals(role)) {
                session.setAttribute("loggedIn", true);
                return "redirect:admin";
            } else {
                session.setAttribute("loggedIn", true);
                return "redirect:userDetails";
            }
        } else {
            model.addAttribute("loginError", "Invalid username or password");

            return "login";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

        UserValidator.validateFirstName(user.getFirstName(), bindingResult, model);
        UserValidator.validateLastName(user.getLastName(), bindingResult, model);
        UserValidator.validateUserName(user.getUserName(), bindingResult, model);
        UserValidator.validateEmail(user.getEmailAddress(), bindingResult, model);
        UserValidator.validatePassword(user.getPassword(), bindingResult, model);
        UserValidator.validateContactNo(user.getContactNo(), bindingResult, model);

        if (userService.isEmailAlreadyRegistered(user.getEmailAddress())) {
            bindingResult.rejectValue("emailAddress", "error.user", "Email is already registered");
            model.addAttribute("emailError", "Email is already registered");
        }
        if (userService.isUsernameAlreadyRegistered(user.getUserName())) {
            bindingResult.rejectValue("userName", "error.user", "Username already exists! Please use a different username.");
            model.addAttribute("userNameError", "Username already exists! Please use a different username.");
        }
        // Check for validation errors before registering the user
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerUser(user);
            return "register";
        }



    @RequestMapping(value = "/userDetails", method = RequestMethod.GET)
    public String showUserDashboard(HttpSession session, Model model) {
        System.out.println("Inside user dashboard...");
        Integer id = (int) session.getAttribute("userId");
        if (id == null){
            return "redirect:/login";
        }
        int userid = id.intValue();
        User user = this.userService.getUserById(userid);
        List<Address> addresses = user.getAddresses();
        model.addAttribute("user", user);
        model.addAttribute("addresses", addresses);

        return "userDetails";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute User user, HttpServletRequest req, BindingResult bindingResult, HttpSession session, Model model) {

        if (bindingResult.hasErrors()) {
            return "userDetails";
        }

        userService.updateAddressesAndUser(user, req);
        String role = (String) session.getAttribute("role");
        if ("ADMIN".equals(role)) {
            // Add the updated user to the model
            model.addAttribute("updatedUser", user);

            // Redirect to the admin page
            return "redirect:/admin";
        } else {
            // Redirect to the user details page
            return "redirect:/userDetails";
        }
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String errorPage() {
        return "error";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, HttpSession session) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            User existingUser = userService.getUserByUsername(loggedInUser);
            List<User> userList = userService.getAllUsers();

            // Filter users to exclude those with "ADMIN" role
            List<User> filteredUserList = userList.stream()
                    .filter(user -> !"ADMIN".equalsIgnoreCase(user.getRole()))
                    .toList();

            // Set the filtered list of users as a model attribute
            model.addAttribute("userList", filteredUserList);
            model.addAttribute("admin", existingUser);

            return "admin";
        } else {
            return "login";
        }
    }

    @RequestMapping(path = "/userDetails/{id}", method = RequestMethod.GET)
    public String viewPage(HttpSession session, @PathVariable("id") int id) {
        session.setAttribute("userId", id);
        return "redirect:/userDetails";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        return "redirect:/welcome";
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        User user = this.userService.getUserById(id);
        this.userService.deleteUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/forgotPassword", method = RequestMethod.GET)
    public String showForgotPasswordPage() {
        return "forgotPassword";
    }

    @RequestMapping(path = "/enterOtp", method = RequestMethod.GET)
    public String showEnterOtpPage(Model model, HttpSession session) {
        // Retrieve the email from the session or wherever it's stored
        String email = (String) session.getAttribute("email");

        // Add the email to the model
        model.addAttribute("email", email);
        model.addAttribute("message", "Enter Your Otp");

        // Return the view name
        return "enterOtp";
    }


    @RequestMapping(path = "/forgotPassword", method = RequestMethod.POST)
    public String forgotPassword(@Valid @RequestParam @Email(message = "Invalid Email Address..") String email, HttpSession httpSession, RedirectAttributes redirectAttributes, Model model) {
        int otpValue;
        String message;

        if (email != null && !email.equals("")) {
            try {
                int emailCount = userDAO.checkEmailExistence(email);

                if (emailCount == 0) {
                    message = "Email is not registered. Please use a registered email address.";
                    redirectAttributes.addFlashAttribute("message", message);
                    return "redirect:/forgotPassword";
                } else {
                    Random rand = new Random();
                    otpValue = rand.nextInt(1255650);

                    // Rest of the code for sending email
                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");

                    Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("panchaldeep113@gmail.com", "ugbimjuhqkxbcopr");
                        }
                    });

                    try {
                        MimeMessage messageObject = new MimeMessage(mailSession);
                        messageObject.setFrom(new InternetAddress(email));
                        messageObject.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                        messageObject.setSubject("Hello");
                        messageObject.setText("Your OTP is: " + otpValue);
                        Transport.send(messageObject);

                        message = "OTP is sent to your email id successfully";
                        System.out.println("Message sent successfully");
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }

                    httpSession.setAttribute("otp", otpValue);
                    httpSession.setAttribute("email", email);
                    redirectAttributes.addFlashAttribute("message", message);
                    return "redirect:/enterOtp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/forgot";
    }



    @RequestMapping(path = "/validateOtp", method = RequestMethod.POST)
    public String validateOtp(@RequestParam int otp,
                              @RequestParam String email,
                              HttpSession session,
                              Model model) {

        Integer storedOtp = (int) session.getAttribute("otp");

        if (otp == storedOtp) {
            model.addAttribute("email", email);
            model.addAttribute("status", "success");
            return "redirect:/newPassword"; // Assuming newPassword is the view name
        } else {
            model.addAttribute("message", "Wrong OTP");
            return "redirect:/enterOtp"; // Assuming enterOtp is the view name
        }
    }


    @RequestMapping(path = "/newPassword", method = RequestMethod.GET)
    public String showResetPasswordPage() {
        return "newPassword";
    }


    @RequestMapping(path = "/resetPassword", method = RequestMethod.POST)
    public String resetPassword(@RequestParam String password,
                                @RequestParam String confPassword,
                                HttpSession session, Model model) {

        if (password != null && password.equals(confPassword)) {
            String email = (String) session.getAttribute("email");
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

            boolean updateSuccess = userDAO.updateUserPassword(email, encodedPassword);

            if (updateSuccess) {
                model.addAttribute("status", "resetSuccess");
            } else {
                model.addAttribute("status", "resetFailed");
            }

            return "login";
        }

        return "redirect:/login";
    }
}
