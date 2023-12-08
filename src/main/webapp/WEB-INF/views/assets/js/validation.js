 var currdate = new Date();
        var month = currdate.getMonth() + 1;
        var year = currdate.getUTCFullYear();
        var todayDate = currdate.getDate() - 3;
        if (todayDate < 10) {
            todayDate = '0' + todayDate;
        }
        if (month < 10) {
            month = '0' + month;
        }
        var maxDate = year + '-' + month + '-' + todayDate;
        $('#birthdayDate').attr('max', maxDate);

        $('#form').on('reset', function () {
            $('input[name=firstName]').removeClass('add-border-green');
            $('input[name=firstName]').addClass('add-border-red');
            $('input[name=lastName]').removeClass('add-border-green');
            $('input[name=lastName]').addClass('add-border-red');
            $('input[name=userName]').removeClass('add-border-green');
            $('input[name=userName]').addClass('add-border-red');
            $('input[name=emailAddress]').removeClass('add-border-green');
            $('input[name=emailAddress]').addClass('add-border-red');
            $('input[name=password]').removeClass('add-border-green');
            $('input[name=password]').addClass('add-border-red');
            $('input[name=cpassword]').removeClass('add-border-green');
            $('input[name=cpassword]').addClass('add-border-red');
        });

        var formValid = {
            firstname: false,
            lastname: false,
            username: false,
            birthdate: false,
            email: false,
            password: false,
            confirmPassword: false,
            contactNo: false,
            selectcity: false
        };

        function checkValidation() {
            if (formValid.firstname && formValid.lastname && formValid.email && formValid.password && formValid.confirmPassword) {
                $('#submit').removeAttr('disabled');
            } else {
                $('#submit').attr('disabled', true);
            }
        }

        $('#firstName').on('input', function () {
            var firstname = $(this).val();
            function msg(body) {
                $('#firstname-error').text(body).show();
            };
            function hide() {
                $('#firstname-error').hide();
            };
            if (firstname.length == 0) {
                msg('Please Enter Your First Name.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.firstname = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.firstname = true;
                checkValidation();
                var testExp = new RegExp(/^[a-zA-Z]+$/);
                if (!testExp.test(firstname)) {
                    msg('Should not have any special characters or Numbers');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.firstname = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.firstname = true;
                    checkValidation();
                    if (firstname.length < 3 || firstname.length > 10) {
                        msg('Must be at least 3 characters but no more than 10');
                        $(this).addClass('add-border-red');
                        $(this).removeClass('add-border-green');
                        formValid.firstname = false;
                        checkValidation();
                    } else {
                        $(this).addClass('add-border-green');
                        $(this).removeClass('add-border-red');
                        hide();
                        formValid.firstname = true;
                        checkValidation();
                    }
                }
            }
        });

        $('#lastName').on('input', function () {
            var lastname = $(this).val();
            function msg(body) {
                $('#lastname-error').text(body).show();
            };
            function hide() {
                $('#lastname-error').hide();
            };
            if (lastname.length < 1) {
                msg('Please Enter Your Last Name.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.lastname = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.lastname = true;
                checkValidation();
                var testExp = new RegExp(/^[a-zA-Z]+$/);
                if (!testExp.test(lastname)) {
                    msg('Should not have any special characters or Numbers');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.lastname = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.lastname = true;
                    checkValidation();
                    if (lastname.length < 3 || lastname.length > 10) {
                        msg('Must be at least 3 characters but no more than 10');
                        $(this).addClass('add-border-red');
                        $(this).removeClass('add-border-green');
                        formValid.lastname = false;
                        checkValidation();
                    } else {
                        $(this).addClass('add-border-green');
                        $(this).removeClass('add-border-red');
                        hide();
                        formValid.lastname = true;
                        checkValidation();
                    }
                }
            }
        });

        $('#userName').on('input', function () {
            var username = $(this).val();
            function msg(body) {
                $('#username-error').text(body).show();
            };
            function hide() {
                $('#username-error').hide();
            };
            if (username.length == 0) {
                msg('Please Enter Your User Name.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.firstname = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.firstname = true;
                checkValidation();
                var testExp = new RegExp(/^[a-zA-Z]+$/);
                if (!testExp.test(username)) {
                    msg('Should not have any special characters or Numbers');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.firstname = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.firstname = true;
                    checkValidation();
                    if (username.length < 3 || username.length > 10) {
                        msg('Must be at least 3 characters but not more than 10');
                        $(this).addClass('add-border-red');
                        $(this).removeClass('add-border-green');
                        formValid.firstname = false;
                        checkValidation();
                    } else {
                        $(this).addClass('add-border-green');
                        $(this).removeClass('add-border-red');
                        hide();
                        formValid.firstname = true;
                        checkValidation();
                    }
                }
            }
        });

        $('#emailAddress').on('input', function () {
            var email = $(this).val();
            function msg(body) {
                $('#email-error').text(body).show();
            };
            function hide() {
                $('#email-error').hide();
            };
            if (email.length < 1) {
                msg('Please Enter Your Email.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.email = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.email = true;
                checkValidation();
                var testExp = new RegExp(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/);
                if (!testExp.test(email)) {
                    msg('Enter A Valid Email Address.');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.email = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.email = true;
                    checkValidation();
                    if (email.length < 3 || email.length > 30) {
                        msg('Must be at least 3 characters but no more than 30');
                        $(this).addClass('add-border-red');
                        $(this).removeClass('add-border-green');
                        formValid.email = false;
                        checkValidation();
                    } else {
                        $(this).addClass('add-border-green');
                        $(this).removeClass('add-border-red');
                        hide();
                        formValid.email = true;
                        checkValidation();
                    }
                }
            }
        });

        $('#password').on('input', function () {
            var password = $(this).val();
            function msg(body) {
                $('#password-error').text(body).show();
            };
            function hide() {
                $('#password-error').hide();
            };
            if (password.length < 1) {
                msg('Please Enter Your Password.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.password = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.password = true;
                checkValidation();
                if (password.length < 6 || password.length > 20) {
                    msg('Must be at least 6 characters but no more than 20');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.password = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.password = true;
                    checkValidation();
                }
            }
        });

        $('#cpassword').on('input', function () {
            var cpassword = $(this).val();
            function msg(body) {
                $('#cpassword-error').text(body).show();
            };
            function hide() {
                $('#cpassword-error').hide();
            };
            var password = $('#password').val();
            if (cpassword != password) {
                msg('Passwords do not match.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.confirmPassword = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.confirmPassword = true;
                checkValidation();
            }
        });

        $('#contactNo').on('input', function () {
            var contactno = $(this).val();
            function msg(body) {
                $('#contact-error').text(body).show();
            };
            function hide() {
                $('#contact-error').hide();
            };
            if (contactno.length < 1) {
                msg('Please Enter Your Contact Number.');
                $(this).addClass('add-border-red');
                $(this).removeClass('add-border-green');
                formValid.contactNo = false;
                checkValidation();
            } else {
                $(this).addClass('add-border-green');
                $(this).removeClass('add-border-red');
                hide();
                formValid.contactNo = true;
                checkValidation();
                var testExp = new RegExp(/^[0-9]+$/);
                if (!testExp.test(contactno)) {
                    msg('Should not have any special characters or alphabets');
                    $(this).addClass('add-border-red');
                    $(this).removeClass('add-border-green');
                    formValid.contactNo = false;
                    checkValidation();
                } else {
                    $(this).addClass('add-border-green');
                    $(this).removeClass('add-border-red');
                    hide();
                    formValid.contactNo = true;
                    checkValidation();
                    if (contactno.length != 10) {
                        msg('Must be exactly 10 digits');
                        $(this).addClass('add-border-red');
                        $(this).removeClass('add-border-green');
                        formValid.contactNo = false;
                        checkValidation();
                    } else {
                        $(this).addClass('add-border-green');
                        $(this).removeClass('add-border-red');
                        hide();
                        formValid.contactNo = true;
                        checkValidation();
                    }
                }
            }
        });




       var cityValid = {};


       function checkValidation() {
           var allCityFieldsValid = true;


           $('[name^="selectCity"]').each(function() {
               var fieldName = $(this).attr('name');
               var cityValue = $(this).val();


               if (!cityValue) {
                   allCityFieldsValid = false;
                   cityValid[fieldName] = false;
               } else {
                   cityValid[fieldName] = true;
               }
           });


           if (
               formValid.firstname &&
               formValid.lastname &&
               formValid.email &&
               formValid.password &&
               formValid.confirmPassword &&
               formValid.contactNo &&
               allCityFieldsValid // Check if all city fields are valid
           ) {
               $('#submit').removeAttr('disabled');
           } else {
               $('#submit').attr('disabled', true);
           }
       }

       $('[name^="selectCity"]').on('change', function () {
           var cityValue = $(this).val();
           var fieldName = $(this).attr('name');

           if (!cityValue) {

               $(this).addClass('add-border-red');
               $(this).removeClass('add-border-green');
               cityValid[fieldName] = false;
           } else {

               $(this).addClass('add-border-green');
               $(this).removeClass('add-border-red');
               cityValid[fieldName] = true;
           }

           checkValidation();
       });

     $('#remove-address').hide();

     $('#remove-address').hide();

     $('#add-address').on('click', function () {
         var addressFields = $('#address-fields');
         var addressCount = addressFields.find('.row').length; // Updated this line

         var newAddressField = '<div class="row mt-4">' +
             '<div class="col-md-6">' +
             '<label class="form-label font-weight-bold">Street Address :</label>' +
             '<input type="text" class="form-control form-control-lg" name="addresses[' + addressCount + '].address1" required />' +
             '</div>' +
             '<div class="col-md-3">' +
             '<label class="form-label font-weight-bold">Apartment No. :</label>' +
             '<input type="text" class="form-control form-control-lg" name="addresses[' + addressCount + '].apartment1" required />' +
             '</div>' +
             '<div class="col-md-3">' +
             '<label class="form-label font-weight-bold">ZIP code  :</label>' +
             '<input type="text" class="form-control form-control-lg" name="addresses[' + addressCount + '].zipcode1" required />' +
             '</div>' +
             '<div class="col-md-6 mt-4">' +
             '<label class="form-label font-weight-bold">City :</label>' +
             '<select class="select form-control-lg" name="addresses[' + addressCount + '].selectCity" required>' +
             '<option value="" selected hidden>Select</option>' +
             '<option value="Vadodara">Vadodara</option>' +
             '<option value="Ahmedabad">Ahmedabad</option>' +
             '<option value="Surat">Surat</option>' +
             '<option value="Bharuch">Bharuch</option>' +
             '<option value="Mumbai">Mumbai</option>' +
             '<option value="Ujjain">Ujjain</option>' +
             '<option value="Indore">Indore</option>' +
             '<option value="Udaipur">Udaipur</option>' +
             '<option value="Jodhpur">Jodhpur</option>' +
             '<option value="Prayagraj">Prayagraj</option>' +
             '</select>' +
             '</div>' +
             '<div class="col-md-6 mt-4">' +
             '<label class="form-label font-weight-bold">State :</label>' +
             '<select class="select form-control-lg" name="addresses[' + addressCount + '].selectState" required>' +
             '<option value="" selected hidden>Select</option>' +
             '<option value="Gujarat">Gujarat</option>' +
             '<option value="Maharashtra">Maharashtra</option>' +
             '<option value="Rajasthan">Rajasthan</option>' +
             '<option value="Uttar Pradesh">Uttar Pradesh</option>' +
             '<option value="Madhya Pradesh">Madhya Pradesh</option>' +
             '</select>' +
             '</div>' +
             '</div>';

         addressFields.append(newAddressField);
         $('#remove-address').show();
     });


         $('#remove-address').on('click', function () {
                var addressFields = $('#address-fields');
                var addressCount = addressFields.find('.row').length;

                // Ensure there is at least one address section before removing
                if (addressCount > 1) {
                    // Remove the last added address section
                    addressFields.find('.row:last').remove();

                    // If there's only one address left, hide the "Remove Address" button
                    if (addressCount === 2) {
                        $('#remove-address').hide();
                    }
                }
            });

             $(document).ready(function () {
                    // Function to validate street address
                    $("#address1").on("input", function () {
                        var streetAddress = $(this).val();
                        var streetAddressPattern = /^[a-zA-Z0-9\s]+$/; // Allow only letters, numbers, and spaces
                        var isValid = streetAddressPattern.test(streetAddress);

                        var feedbackDiv = $("#streetAddressFeedback");

                        if (isValid) {
                            feedbackDiv.removeClass("invalid-feedback").addClass("valid-feedback").addClass("d-block").text("Valid");
                        } else {
                            feedbackDiv.removeClass("valid-feedback").addClass("invalid-feedback").addClass("d-block").text("Invalid street address ! No Special Characters Allowed");
                        }
                    });

                    // Function to validate apartment number
                    $("#apartment1").on("input", function () {
                        var apartmentNumber = $(this).val();
                        var apartmentNumberPattern = /^[0-9]+$/; // Allow only numbers
                        var isValid = apartmentNumberPattern.test(apartmentNumber);

                        var feedbackDiv = $("#apartmentNumberFeedback");

                        if (isValid) {
                            feedbackDiv.removeClass("invalid-feedback").addClass("valid-feedback").addClass("d-block").text("Valid");
                        } else {
                            feedbackDiv.removeClass("valid-feedback").addClass("invalid-feedback").addClass("d-block").text("Invalid apartment number. Only numbers are allowed.");
                        }
                    });

                    // Function to validate ZIP code
                    $("#zipcode1").on("input", function () {
                        var zipCode = $(this).val();
                        var zipCodePattern = /^[0-9]+$/; // Allow only numbers
                        var isValid = zipCodePattern.test(zipCode);

                        var feedbackDiv = $("#zipCodeFeedback");

                        if (isValid) {
                            feedbackDiv.removeClass("invalid-feedback").addClass("valid-feedback").addClass("d-block").text("Valid");
                        } else {
                            feedbackDiv.removeClass("valid-feedback").addClass("invalid-feedback").addClass("d-block").text("Invalid ZIP code. Only numbers are allowed.");
                        }
                    });
                });