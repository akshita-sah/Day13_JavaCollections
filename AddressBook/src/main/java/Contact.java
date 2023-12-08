class Contact
{
    String firstName,lastName,address,city,state,zip,phoneNumber;

    /* Parameterized Constructor for initializing the class variables */
    Contact(String fName,String lName,String addressFull,String cityName,String stateName,String zipCode,String phnNumber)
    {
        firstName = fName;
        lastName = lName;
        address = addressFull;
        city = cityName;
        state = stateName;
        zip = zipCode;
        phoneNumber = phnNumber;
    }

    void display()
    {
        System.out.println("The details of the contacts are: ");
        System.out.println("First name : " + firstName);
        System.out.println("Last name : " + lastName);
        System.out.println("Address : " + address);
        System.out.println("City : " + city);
        System.out.println("State : " + state);
        System.out.println("Zip : " + zip);
        System.out.println("Phone number : " + phoneNumber);
    }

    void setAddress(String addressFull) {
        address = addressFull;
    }

    void setCity(String cityName) {
        city = cityName;
    }

    void setState(String stateName) {
        state = stateName;
    }

    void setZip(String zipCode) {
        zip = zipCode;
    }

    void setPhoneNumber(String phnNumber) {
        phoneNumber = phnNumber;
    }
}
