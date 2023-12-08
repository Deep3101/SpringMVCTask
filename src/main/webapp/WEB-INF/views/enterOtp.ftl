<#include "header.ftl">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous" />
    <title>Enter OTP</title>
    <style>
<#include "./assets/css/style7.css">
    </style>
</head>
<body>
    <#include "header.ftl">
       <div class="container center-content">
           <div class="col-md-4 form-container">
               <div class="forgot">
                   <h2>Enter your OTP</h2>
               </div>
               <form action="validateOtp" method="POST">
                   <#assign message = message?default("")>
                   <#if message??>
                       <div class="success-message">${message}</div>
                   </#if>
                   <div class="form-group">
                                       <label for="email">Email:</label>
                                       <input class="form-control" type="text" name="email" id="email" value="${email}" readonly>
                                   </div>
                   <div class="form-group">
                       <label for="otp">Enter OTP :</label>
                       <input class="form-control" type="text" name="otp" id="otp" required="">
                       <small class="form-text text-muted">Enter the OTP you received in your email.</small>
                   </div>
                   <button class="btn btn-success btn-block" type="submit">Reset Password</button>
                   <button class="btn btn-danger btn-block" type="button" onclick="window.location.href='login'">Back to Login</button>
               </form>
           </div>
       </div>
       <#include "footer.ftl">
   </body>
</html>
