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
      <#include "./assets/css/style8.css">
    </style>
</head>
<#include "header.ftl">
<div class="container center-content">
    <div class="col-md-4 form-container">
        <div class="forgot">
            <h2>Reset your password</h2>
            <p>Choose a new password to secure your account.</p>
        </div>
        <form action="resetPassword" method="POST" onsubmit="return validatePasswordResetForm();">
            <div>
                <#if message??>
                    <div class="error-message">${message}</div>
                </#if>
            </div>
            <div class="form-group">
                <label for="password">New Password :</label>
                <input class="form-control" type="password" name="password" id="password" required="" onkeyup="validatePassword()">
                <div id="password-error" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="confPassword">Confirm New Password :</label>
                <input class="form-control" type="password" name="confPassword" id="confPassword" required="" onkeyup="validatePassword()">
                <div id="confPassword-error" class="error-message"></div>
            </div>
            <button class="btn btn-success btn-block" type="submit">Reset Password</button>
            <button class="btn btn-danger btn-block" type="button" onclick="window.location.href='login'">Back to Login</button>
            <hr>
            <p>Don't Have An Account ?<a href="register" class="text-danger"> Register Now</a></p>
        </form>
    </div>
</div>

<#include "footer.ftl">

<script>
        <#include "./assets/jquery/jQuery 3.6.4.js">
        <#include "./assets/jquery/jquery-ui.js">
        <#include "./assets/js/newpassword.js">
</script>
</body>
</html>
