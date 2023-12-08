<#ftl output_format="HTML" encoding="UTF-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous" />
    <title>Login</title>
    <style>
      <#include "./assets/css/style3.css">
    </style>
</head>

<#if loggedInUser??>
    <#if role == "ADMIN">
        <#return "<#redirect 'adminDashboard.ftl' />">
    <#else>
        <#return "<#redirect 'userDashboard.ftl' />">
    </#if>
</#if>

<body>
<#include "header.ftl" />

<div class="container center-content">
    <div class="col-md-4 form-container">
        <h3>Welcome to Login Page</h3>
         <#if loginError??>
                    <div class="alert alert-danger" role="alert">
                        ${loginError}
                    </div>
                </#if>
        <form action="loginUser" method="post" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="username">Username :</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
                <p id="username-error" class="error-message"></p>
            </div>
            <div class="form-group">
                <label for="password">Password :</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                <p id="password-error" class="error-message"></p>
            </div>
            <button type="submit" class="btn btn-primary btn-block" style="box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.3)">Login</button>
        </form>
        <div class="forgot-password">
            <a href="forgotPassword">Forgot Password?</a>
        </div>
        <div>Not Registered? <a href="register">Click Here</a></div>
    </div>
</div>

<#include "footer.ftl" />

<script>
        <#include "./assets/jquery/jQuery 3.6.4.js">
        <#include "./assets/jquery/jquery-ui.js">
        <#include "./assets/js/userlogin.js">
</script>
</body>
</html>
