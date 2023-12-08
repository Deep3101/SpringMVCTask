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
        <#include "./assets/css/style5.css">
    </style>
</head>
<body>
<#include "header.ftl" />
<div class="content">
    <h1>Welcome to Admin Dashboard</h1>
    <a href="register" class="btn btn-success add-user-button">Add User</a>
    <form action="logout" method="get" class="logout-form">
            <button type="submit" class="btn btn-warning btn-sm">Logout</button>
        </form>
    <div class="admin-table-container">
        <table border="1" class="table table-striped admin-table">
            <thead class="table table-secondary">
                <tr>
                    <th>UserId</th>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Contact</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <#if updatedUser??>
                    <!-- Display updated user details in the table -->
                    <tr>
                        <td>${updatedUser.userId}</td>
                        <td>${updatedUser.userName}</td>
                        <td>${updatedUser.firstName}</td>
                        <td>${updatedUser.lastName}</td>
                        <td>${updatedUser.emailAddress}</td>
                        <td>${updatedUser.contactNo}</td>
                        <td>${updatedUser.role}</td>
                        <td>
                            <a href="userDetails/${updatedUser.userId}" class="btn btn-primary">View</a>
                            <a href="delete/${updatedUser.userId}" class="btn btn-danger py-1 remove-user-btn">Delete</a>
                        </td>
                    </tr>
                <#else>
                    <!-- Display user details from the model as before -->
                    <#list userList as user>
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.userName}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.emailAddress}</td>
                            <td>${user.contactNo}</td>
                            <td>${user.role}</td>
                            <td>
                                <a href="userDetails/${user.userId}" class="btn btn-primary">View</a>
                                <a href="delete/${user.userId}" class="btn btn-danger py-1 remove-user-btn">Delete</a>
                            </td>
                        </tr>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>
</div>

<#include "footer.ftl">
</body>
<script>
    <#include "./assets/jquery/jQuery 3.6.4.js">
    <#include "./assets/jquery/jquery-ui.js">
</script>
</html>
