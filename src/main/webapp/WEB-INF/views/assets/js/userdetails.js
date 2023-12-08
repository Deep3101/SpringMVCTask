  document.addEventListener("DOMContentLoaded", function () {
        // Function to make form fields editable
        function makeFieldsEditable() {
            const inputFields = document.querySelectorAll(".form-control");
            inputFields.forEach(function (input) {
                // Check if it's the username field
                    input.removeAttribute("disabled");
            });

            // Enable the "Save Changes" and "Add Address" buttons
            document.getElementById("saveButton").style.display = "inline";
            document.getElementById("addAddressButton").style.display = "inline";
            // Show the "Remove Address" buttons
            const removeAddressButtons = document.querySelectorAll(".remove-address-button");
            removeAddressButtons.forEach(function (button) {
                button.style.display = "inline";
            });
        }

        // Function to make form fields readable
        function makeFieldsReadable() {
            const inputFields = document.querySelectorAll(".form-control");
            inputFields.forEach(function (input) {
                input.setAttribute("disabled", "disabled");
            });

            // Disable the "Save Changes" and "Add Address" buttons
            document.getElementById("saveButton").style.display = "none";
            document.getElementById("addAddressButton").style.display = "none";
            // Hide the "Remove Address" buttons
            const removeAddressButtons = document.querySelectorAll(".remove-address-button");
            removeAddressButtons.forEach(function (button) {
                button.style.display = "none";
            });
        }

        // Function to add a new address field
        function addAddressField() {
            // Clone the first address form field (assuming it's present initially)
            const firstAddressField = document.querySelector(".address-form");
            const newAddressField = firstAddressField.cloneNode(true);

            // Clear the values in the cloned address field
            const clonedInputs = newAddressField.querySelectorAll("input");
            clonedInputs.forEach(function (input) {
                input.value = "";
            });

            // Add the cloned address field to the form
            const addressForm = document.querySelector(".user-details form");
            addressForm.insertBefore(newAddressField, document.getElementById("addAddressButton"));

            // Enable the "Remove Address" button for the new address field
            const removeAddressButton = newAddressField.querySelector(".remove-address-button");
            removeAddressButton.style.display = "inline";

            // Attach an event listener to the new "Remove Address" button
            removeAddressButton.addEventListener("click", function () {
                // Handle the removal of the address field here
                // You can access the address ID using this.getAttribute("data-address-id")
                // Remove the corresponding address field and perform any other required actions
                const addressId = this.getAttribute("data-address-id");
                const addressField = this.closest(".address-form");
                // Remove the address field associated with this addressId
                addressField.remove();
            });
        }

        // Event listener for the "Edit" button
        document.getElementById("editButton").addEventListener("click", function () {
            makeFieldsEditable();
            // Show the "Add Address" button
            document.getElementById("addAddressButton").style.display = "inline";

             if (document.querySelectorAll(".address-form").length === 0) {
                    document.getElementById("addAddressButton").style.display = "inline";
                }
             const genderRadioButtons = document.querySelectorAll("[name='gender']");
                 genderRadioButtons.forEach(function (radioButton) {
                     if (!radioButton.hasAttribute("disabled")) {
                         radioButton.removeAttribute("disabled");
                     }
                 });
            });

        // Event listener for the "Add Address" button
        document.getElementById("addAddressButton").addEventListener("click", function () {
            addAddressField();
        });

        // Event listener for the "Remove Address" buttons (initially displayed ones)
        const removeAddressButtons = document.querySelectorAll(".remove-address-button");
        removeAddressButtons.forEach(function (button) {
            button.addEventListener("click", function () {
                // Handle the removal of the address field here
                // You can access the address ID using this.getAttribute("data-address-id")
                // Remove the corresponding address field and perform any other required actions
                const addressId = this.getAttribute("data-address-id");
                const addressField = this.closest(".address-form");
                // Remove the address field associated with this addressId
                addressField.remove();
            });
        });

        // Initially, make fields readable
        makeFieldsReadable();
        // Function to validate fields
                    function validateFields() {
                        const firstName = document.getElementById("userFirstName").value;
                        const lastName = document.getElementById("userLastName").value;
                        const contact = document.getElementById("contact").value;
                        const streetAddress = document.getElementById("streetAddress").value;
                        const apartmentNumber = document.getElementById("apartmentNumber").value;
                        const zipCode = document.getElementById("zipCode").value;
                        const city = document.getElementById("city").value;
                        const state = document.getElementById("state").value;

                        // Regular expressions for validation
                        const nameRegex = /^[A-Za-z]+$/;
                        const contactRegex = /^\d{10}$/; // For a 10-digit number
                        const streetRegex = /^[A-Za-z0-9\s\-,.]+$/;
                        const apartmentRegex = /^\d+$/; // For positive integers
                        const zipCodeRegex = /^\d{3}$/; // For a 5-digit ZIP code
                        const cityRegex = /^[A-Za-z\s]+$/;
                        const stateRegex = /^[A-Za-z\s]+$/;


                        // Error messages
                        const firstNameError = document.getElementById("firstNameError");
                        const lastNameError = document.getElementById("lastNameError");
                        const contactError = document.getElementById("contactError");
                        const streetAddressError = document.getElementById("streetAddressError");
                        const apartmentNumberError = document.getElementById("apartmentNumberError");
                        const zipCodeError = document.getElementById("zipCodeError");
                        const cityError = document.getElementById("cityError");
                        const stateError = document.getElementById("stateError");

                        // Validate First Name
                        if (!nameRegex.test(firstName)) {
                            firstNameError.innerText = "First Name is not valid.";
                            return false;
                        } else {
                            firstNameError.innerText = "";
                        }

                        // Validate Last Name
                        if (!nameRegex.test(lastName)) {
                            lastNameError.innerText = "Last Name is not valid.";
                            return false;
                        } else {
                            lastNameError.innerText = "";
                        }

                        // Validate Contact
                        if (!contactRegex.test(contact)) {
                            contactError.innerText = "Contact is not valid. It should be a 10-digit number.";
                            return false;
                        } else {
                            contactError.innerText = "";
                        }

                        //Validate Street Address
                        if(!streetRegex.test(streetAddress)){
                             streetAddressError.innerText = "Street Address Not Valid. Don't Use Special Characters Like @ #";
                             return false;
                        }else {
                              streetAddressError.innerText = "";
                        }

                        // Validate Apartment Number
                        if (!apartmentRegex.test(apartmentNumber)) {
                            apartmentNumberError.innerText = "Apartment Number is not valid. It should be a positive integer.";
                            return false;
                        } else {
                            apartmentNumberError.innerText = "";
                        }

                        // Validate ZIP Code
                        if (!zipCodeRegex.test(zipCode)) {
                            zipCodeError.innerText = "ZIP Code is not valid. It should be a 3 digit number.";
                            return false;
                        } else {
                            zipCodeError.innerText = "";
                        }

                        //Validate City and state
                        if(!cityRegex.test(city)){
                            cityError.innerText = "City Invalid. Don't use Numbers or special characters.";
                            return false;
                        }else{
                            cityError.innerText = "";
                        }

                        if(!stateRegex.test(state)){
                            stateError.innerText = "State Invalid. Don't use Numbers or special characters.";
                            return false;
                        }

                        return true; // All fields are valid
                    }

                    // Event listener for the "Save Changes" button
                    document.getElementById("saveButton").addEventListener("click", function (event) {
                        if (!validateFields()) {
                            event.preventDefault(); // Prevent form submission if validation fails
                        }
                    });
    });