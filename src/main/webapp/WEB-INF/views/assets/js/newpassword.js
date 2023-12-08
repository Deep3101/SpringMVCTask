 function validatePasswordResetForm() {
            var newPassword = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confPassword").value;


            var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$/;

            if (newPassword === "" || confirmPassword === "") {
                document.getElementById("password-error").innerHTML = "Both password fields are required.";
                document.getElementById("confPassword-error").innerHTML = "";
                return false;
            } else {
                document.getElementById("password-error").innerHTML = "";
                document.getElementById("confPassword-error").innerHTML = "";
            }

            if (newPassword !== confirmPassword) {
                document.getElementById("password-error").innerHTML = "";
                document.getElementById("confPassword-error").innerHTML = "Passwords do not match.";
                return false;
            } else {
                document.getElementById("password-error").innerHTML = "";
                document.getElementById("confPassword-error").innerHTML = "";
            }

            if (!passwordRegex.test(newPassword)) {
                document.getElementById("password-error").innerHTML = "Password must contain at least one uppercase letter, one lowercase letter, one digit, one special character, and be at least 8 characters long.";
                return false;
            } else {
                document.getElementById("password-error").innerHTML = "";
            }

            return true;
        }

        function validatePassword() {
            var newPassword = document.getElementById("password").value;
            var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$/;


            if (passwordRegex.test(newPassword)) {
                document.getElementById("password-error").innerHTML = "";
                document.getElementById("password").classList.remove("error-border");
                document.getElementById("password").classList.add("success-border");
            } else {
                document.getElementById("password").classList.remove("success-border");
                document.getElementById("password").classList.add("error-border");
            }
        }