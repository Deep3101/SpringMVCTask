<#ftl output_format="HTML" encoding="UTF-8">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
          crossorigin="anonymous" />
    <title>User Details</title>
    <style>
      <#include "./assets/css/style6.css">
    </style>
</head>
<#include "header.ftl">
<div class="container center-content">
    <div class="col-md-4 form-container">
        <div class="forgot">
            <h2>Forgot your password?</h2>
            <p>Change your password in three easy steps. This will help you secure your password!</p>
            <div class="steps">
                <div class="step">1. Enter your email address below.</div>
                <div class="step">2. Our system will send you an OTP to your email.</div>
                <div class="step">3. Enter the OTP on the next page.</div>
            </div>
        </div>
        <form action="forgotPassword" method="POST">
            <div>
                <#if message??>
                    <div class="error-message">${message}</div>
                </#if>
            </div>
            <div class="form-group">
                <label for="email-for-pass">Enter your email address :</label>
                <input class="form-control" type="email" name="email" id="email-for-pass" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}">
                <small class="form-text text-muted">Enter the registered email address. We'll send an OTP to this Email address.</small>
            </div>
            <button class="btn btn-success btn-block" type="submit">Reset Password</button>
            <button class="btn btn-danger btn-block" type="button" onclick="window.location.href='login'">Back to Login</button>
        </form>
    </div>
</div>

<#include "footer.ftl">
</body>
<script>
    <#include "./assets/jquery/jQuery 3.6.4.js">
    <#include "./assets/jquery/jquery-ui.js">
</script>
</html>