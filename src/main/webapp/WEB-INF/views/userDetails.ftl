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
      <#include "./assets/css/style4.css">
    </style>
</head>
<body>
<#include "header.ftl" />
<div class="content">
    <div class="user-details">
        <h2>User Details</h2>
        <form action="edit" method="post">
            <input type="hidden" class="form-control" id="userId" name="userId" value="${user.getUserId()}" disabled>
            <div class="form-group">
                <label for="userName">User Name:</label>
                <input type="text" class="form-control" id="userName" name="userName" value="${user.getUserName()}" readonly  >
            </div>
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" class="form-control" id="userFirstName" name="firstName" value="${user.getFirstName()}" disabled>
                <div class="error-message" id="firstNameError"></div>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" class="form-control" id="userLastName" name="lastName" value="${user.getLastName()}" disabled>
                <div class="error-message" id="lastNameError"></div>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="text" class="form-control" id="userEmail" name="emailAddress" value="${user.getEmailAddress()}" readonly>
            </div>
            <div class="form-group">
                <label for="contactNo">Contact:</label>
                <input type="text" class="form-control" id="userContact" name="contactNo" value="${user.getContactNo()}" disabled>
                <div class="error-message" id="contactError"></div>
            </div>
             <input type="hidden" class="form-control" id="password" name="password" value="${user.getPassword()}">
<div class="form-group" id="genderGroup">
    <input type="hidden" class="form-control" id="role" name="role" value="${user.getRole()}">
</div>
            <h3 class="text-bold"> Addresses : </h3>
            <#list addresses as address>
                <div class="address-form">
                    <div class="form-group">
                        <input type="hidden" name="addressId" value="${address.getAddressId()}">
                        <label for="streetAddress">Street Address:</label>
                        <input type="text" class="form-control" id="streetAddress" name="streetAddress" value="${address.getAddress1()}" disabled>
                        <div class="error-message" id="streetAddressError"></div>
                    </div>
                    <div class="form-group">
                        <label for="apartmentNumber">Apartment Number:</label>
                        <input type="text" class="form-control" id="apartmentNumber" name="apartmentNumber" value="${address.getApartment1()}" disabled>
                        <div class="error-message" id="apartmentNumberError"></div>
                    </div>
                    <div class="form-group">
                        <label for="zipCode">ZIP Code:</label>
                        <input type="text" class="form-control" id="zipCode" name="zipCode" value="${address.getZipcode1()}">
                        <div class="error-message" id="zipCodeError"></div>
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" class="form-control" id="city" name="city" value="${address.getSelectCity()}" >
                        <div class="error-message" id="cityError"></div>
                    </div>
                    <div class="form-group">
                        <label for="state">State:</label>
                        <input type="text" class="form-control" id="state" name="state" value="${address.getSelectState()}" >
                        <div class="error-message" id="stateError"></div>
                    </div>
                    <button type="button" class="btn btn-danger remove-address-button" style="display: none;" data-address-id="${address.getAddressId()}">Remove Address</button>
                </div>
            </#list>
            <!-- Add an edit button to make changes -->
            <button type="button" id="editButton" class="btn btn-success">Edit</button>
            <!-- Add a Save Changes button (hidden initially) -->
            <button type="submit" id="saveButton" class="btn btn-primary" style="display: none;">Save Changes</button>
            <!-- Add an Add Address button -->
            <button type="button" id="addAddressButton" class="btn btn-info" style="display: none;">Add Address</button>
        </form>
        <form action="logout" method="get" class="logout-form">
                <button type="submit" class="btn btn-warning btn-sm">Logout</button>
            </form>
    </div>
</div>
<#include "footer.ftl" />
<script>
 <#include "./assets/jquery/jQuery 3.6.4.js">
 <#include "./assets/jquery/jquery-ui.js">
<#include "./assets/js/userdetails.js">
</script>
</body>
</html>
