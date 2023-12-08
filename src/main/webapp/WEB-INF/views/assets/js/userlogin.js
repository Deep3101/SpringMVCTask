 function validateForm() {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var usernameRegex = /^[a-zA-Z0-9]{3,10}$/;
        var passwordRegex = /^[a-zA-Z0-9!@#$%^&*()_+{}|:"<>?~]{6,20}$/;

        if (!usernameRegex.test(username)) {
            document.getElementById("username-error").innerHTML = "Invalid username";
            document.getElementById("username").classList.add("error-box");
            return false;
        } else {
            document.getElementById("username-error").innerHTML = "";
            document.getElementById("username").classList.remove("error-box");
        }

        if (!passwordRegex.test(password)) {
            document.getElementById("password-error").innerHTML = "Invalid password";
            document.getElementById("password").classList.add("error-box");
            return false;
        } else {
            document.getElementById("password-error").innerHTML = "";
            document.getElementById("password").classList.remove("error-box");
        }

        return true;
    }