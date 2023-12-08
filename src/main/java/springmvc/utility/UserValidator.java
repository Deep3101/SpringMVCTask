package springmvc.utility;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class UserValidator {

    public static void validateFirstName(String firstName, BindingResult bindingResult, Model model) {
        if (firstName == null || firstName.trim().isEmpty()) {
            bindingResult.rejectValue("firstName", "error.user", "First Name is required");
            model.addAttribute("firstNameError", "First Name is required");
        } else if (firstName.length() < 3 || firstName.length() > 10) {
            bindingResult.rejectValue("firstName", "error.user", "First Name must be between 3 and 10 characters");
            model.addAttribute("firstNameError", "First Name must be between 3 and 50 characters");
        }
    }

    public static void validateLastName(String lastName, BindingResult bindingResult, Model model) {
        if (lastName == null || lastName.trim().isEmpty()) {
            bindingResult.rejectValue("lastName", "error.user", "Last Name is required");
            model.addAttribute("lastNameError", "Last Name is required");
        } else if (lastName.length() < 3 || lastName.length() > 10) {
            bindingResult.rejectValue("lastName", "error.user", "Last Name must be between 3 and 10 characters");
            model.addAttribute("lastNameError", "Last Name must be between 3 and 10 characters");
        }
    }

    public static void validateUserName(String userName, BindingResult bindingResult, Model model) {
        if (userName == null || userName.trim().isEmpty()) {
            bindingResult.rejectValue("userName", "error.user", "Username is required");
            model.addAttribute("userNameError", "Username is required");
        } else if (userName.length() < 5 || userName.length() > 10) {
            bindingResult.rejectValue("userName", "error.user", "Username must be between 5 and 10 characters");
            model.addAttribute("userNameError", "Username must be between 5 and 10 characters");
        }
    }

    public static void validateEmail(String email, BindingResult bindingResult, Model model) {
        String emailRegex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$";
        if (email == null || !email.matches(emailRegex)) {
            bindingResult.rejectValue("emailAddress", "error.user", "Invalid email address");
            model.addAttribute("emailError", "Invalid email address");
        }
    }

    public static void validatePassword(String password, BindingResult bindingResult, Model model) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        if (password == null || !password.matches(passwordRegex)) {
            bindingResult.rejectValue("password", "error.user", "Invalid password");
            model.addAttribute("passwordError", "Invalid password");
        }
    }

    public static void validateContactNo(String contactNo, BindingResult bindingResult, Model model) {
        String contactNoRegex = "^\\d{10}$";
        if (contactNo == null || !contactNo.matches(contactNoRegex)) {
            bindingResult.rejectValue("contactNo", "error.user", "Invalid Contact Number");
            model.addAttribute("contactNoError", "Invalid Contact Number");
        }
    }
}
