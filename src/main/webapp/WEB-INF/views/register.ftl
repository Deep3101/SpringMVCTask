<#ftl output_format="HTML" encoding="UTF-8">
<#assign userClass = "com.webapp.model.User">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous" />
    <title>jQuery Form Validation</title>
</head>
<style>
<#include "./assets/css/style.css">
</style>
<body>
<div id="errorDiv">
    <#if errors?has_content>
    <#list errors as error>
    <div class="errorPopup alert bg-danger py-0 m-1" role="alert">${error}</div>
    </#list>
    </#if>
    </div>
        <div id="successPopup"  class="alert bg-success p-2 d-none" role="alert"><#if success?has_content>${success}</#if></div>
<#include "header.ftl">
    <section class="gradient-custom bg-primary">
        <div class="container-fluid py-4">
            <div class="row justify-content-center align-items-center">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">
                                User Registration Form
                            </h3>
                            <form id="form" action="create" method="post" autocomplete="off">
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="firstName">First Name :</label>
                                            <input type="text" id="firstName" class="form-control form-control-lg"
                                                name="firstName" required />
                                            <p id="firstname-error"></p>
                                            <#if firstNameError?has_content>
                                                <div class="alert alert-danger" role="alert">
                                                           ${firstNameError}
                                                </div>
                                            </#if>
                                         </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="lastName">Last Name :</label>
                                            <input type="text" id="lastName" class="form-control form-control-lg"
                                                name="lastName" required />
                                            <p id="lastname-error"></p>
                                           <#if lastNameError?has_content>
                                                  <span style="color: red;">${lastNameError}</span>
                                            </#if>
                                       </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-4 d-flex align-items-center">
                                        <div class="form-outline datepicker w-100">
                                            <label for="birthdayDate" class="form-label font-weight-bold">D.O.B. :</label><br />
                                            <input type="date" name="birthdayDate" id="birthdayDate" required />
                                            <p id="birthday-error"></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="emailAddress">Email :</label>
                                            <input type="email" id="emailAddress" class="form-control form-control-lg"
                                                name="emailAddress" required />
                                            <p id="email-error"></p>
                                          <#if emailError?has_content>
                                                   <span style="color: red;">${emailError}</span>
                                           </#if>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="userName">Username :</label>
                                            <input type="text" id="userName" class="form-control form-control-lg"
                                                name="userName" required />
                                            <p id="username-error"></p>
                                           <#if userNameError?has_content>
                                                 <span style="color: red;">${userNameError}</span>
                                           </#if>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="password">Password :</label>
                                            <input type="password" id="password" class="form-control form-control-lg"
                                                name="password" required />
                                            <p id="password-error"></p>
                                           <#if passwordError?has_content>
                                                 <span style="color: red;">${passwordError}</span>
                                           </#if>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4 pb-2">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="cpassword">Confirm Password :</label>
                                            <input type="password" id="cpassword" class="form-control form-control-lg"
                                                name="cpassword" required />
                                            <p id="cpassword-error"></p>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label font-weight-bold" for="contactNo">Contact No. :</label>
                                            <input type="text" id="contactNo" class="form-control form-control-lg"
                                                name="contactNo" required />
                                            <p id="contact-error"></p>
                                            <#if contactNoError?has_content>
                                                 <span style="color: red;">${contactNoError}</span>
                                             </#if>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4" style="display:none;">
                                         <div class="form-outline">
                                              <label class="form-label font-weight-bold">Role:</label>
                                                     <br><select class="select form-control-lg" name="role" required>
                                                         <option value="USER">User</option>
                                                         <option value="ADMIN">Admin</option>
                                              </select>
                                         </div>
                                    </div>
                                </div>
                                <div id="address-fields">
                                    <div class="row mt-4">
                                        <div class="col-md-6">
                                            <label class="form-label font-weight-bold" for="address1">Street Address :</label>
                                            <input type="text" class="form-control form-control-lg" name="addresses[0].address1" id="address1" required />
                                            <div id="streetAddressFeedback" class="d-none"></div>
                                             <#if address1Error?has_content>
                                                   <span style="color: red;">${address1Error}</span>
                                             </#if>
                                        </div>
                                        <div class="col-md-3">
                                            <label class="form-label font-weight-bold" for="apartment1">Apartment No. :</label>
                                            <input type="text" class="form-control form-control-lg" name="addresses[0].apartment1" id="apartment1" required />
                                            <div id="apartmentNumberFeedback" class="d-none"></div>
                                            <#if address2Error?has_content>
                                              <span style="color: red;">${address2Error}</span>
                                            </#if>
                                        </div>
                                        <div class="col-md-3">
                                            <label class="form-label font-weight-bold" for="zipcode1">ZIP code :</label>
                                            <input type="text" class="form-control form-control-lg" name="addresses[0].zipcode1" id="zipcode1" required />
                                            <div id="zipCodeFeedback" class="d-none"></div>
                                            <#if address3Error?has_content>
                                                <span style="color: red;">${address3Error}</span>
                                            </#if>
                                        </div>
                                        <div class="col-md-6 mt-4">
                                                <label class="form-label font-weight-bold" for="selectCity">City :</label>
                                                <select class="select form-control-lg" name="addresses[0].selectCity" id="selectCity" required>
                                                    <option value="" selected hidden>Select</option>
                                                    <option value="Vadodara">Vadodara</option>
                                                    <option value="Ahmedabad">Ahmedabad</option>
                                                    <option value="Surat">Surat</option>
                                                    <option value="Bharuch">Bharuch</option>
                                                    <option value="Mumbai">Mumbai</option>
                                                    <option value="Ujjain">Ujjain</option>
                                                    <option value="Indore">Indore</option>
                                                    <option value="Udaipur">Udaipur</option>
                                                    <option value="Jodhpur">Jodhpur</option>
                                                    <option value="Prayagraj">Prayagraj</option>
                                                </select>
                                            </div>
                                        <div class="col-md-6 mt-4">
                                                 <label class="form-label font-weight-bold" for="selectState">State :</label>
                                                 <select class="select form-control-lg" name="addresses[0].selectState" id="selectState" required>
                                                      <option value="" selected hidden>Select</option>
                                                      <option value="Gujarat">Gujarat</option>
                                                      <option value="Maharashtra">Maharashtra</option>
                                                      <option value="Rajasthan">Rajasthan</option>
                                                      <option value="Uttar Pradesh">Uttar Pradesh</option>
                                                      <option value="Madhya Pradesh">Madhya Pradesh</option>
                                                 </select>
                                        </div>
                                        <div id="addresses"></div>
                                    </div>
                                        <div id="error-messages" style="color: red;"></div>
                                </div>
                                <button type="button" class="btn btn-primary mt-2" id="add-address">Add Another Address</button>
                                <button type="button" class="btn btn-danger mt-2" id="remove-address">Remove Address</button>
                                <div class="mt-4 pt-2">
                                    <input type="submit" value="Submit" class="btn btn-primary" id="submit"/>
                                    <input type="reset" value="Reset" class="btn btn-secondary" id="reset" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <#include "footer.ftl">
    <script>
        <#include "./assets/jquery/jQuery 3.6.4.js">
        <#include "./assets/jquery/jquery-ui.js">
        <#assign addressCount = 0>
        <#include "./assets/js/validation.js">
    </script>
</body>
</html>
