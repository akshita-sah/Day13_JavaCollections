import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;
class Contact
{
    String firstName,lastName,address,city,state,zip,phoneNumber;

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
public class AddressBook {
    Map<String,Contact>AddressMap;

    AddressBook()
    {
        AddressMap = new HashMap<>();
    }

    void addContact(String fname,String lname,String addressFull,String cityName, String stateName,String zipCode, String phoneNumber)
    {
        Contact c = new Contact(fname,lname,addressFull,cityName,stateName,zipCode,phoneNumber);
        AddressMap.put(fname+lname,c);
        c.display();
    }

    void searchContact(String searchName)
    {
        Contact c = (AddressMap.get(searchName));
        if(c==null)
        {
            System.out.println("Contact not found!");
            return;
        }
        c.display();
        System.out.println("Contact found. Choose the details to edit:");
        System.out.println("1. Address, 2. City, 3. State, 4. Zip,5. Phone number");
        Scanner sc= new Scanner(System.in);
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                System.out.println("Enter the new address: ");
                c.setAddress(sc.nextLine());
                break;
            case 2:
                System.out.println("Enter the new city: ");
                c.setCity(sc.nextLine());
                break;
            case 3:
                System.out.println("Enter the new state: ");
                c.setState(sc.nextLine());
                break;
            case 4:
                System.out.println("Enter the new zip code: ");
                c.setZip(sc.nextLine());
                break;
            case 5:
                System.out.println("Enter the new phone number: ");
                c.setPhoneNumber(sc.nextLine());
                break;
            default:
                System.out.println("Invalid choice");
        }
        c.display();
    }

    void deleteContact(String fname,String lname)
    {
        Contact c = AddressMap.remove(fname+lname);
        if(c==null)
            System.out.println("Contact not found.");
        System.out.println("Contact deleted!");
    }

    boolean checkDuplicate(String name)
    {
        Contact c = (AddressMap.get(name));
        if(c==null)
        {
            return true;
        }
        else return false;
    }

    void displayAllContacts()
    {
        for(String name : AddressMap.keySet())
        {
            Contact c = AddressMap.get(name);
            c.display();
        }
    }

    public static void main(String args[])
    {
        System.out.println("Welcome to Address Book");
        Scanner sc = new Scanner(System.in);
        int n;
        Dictionary<String,AddressBook>AddressBookList = new Hashtable<>();
        System.out.println("Enter number of address books ");
        n = sc.nextInt();
        String nameBook;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the name of the book: ");
            nameBook = sc.next();
            AddressBook book = new AddressBook();
            AddressBookList.put(nameBook,book);
        }
        System.out.println("Enter the address book you want to edit : ");
        nameBook = sc.next();
        AddressBook book2 = AddressBookList.get(nameBook);
        System.out.println("Enter the number of contacts: ");
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String fName,lName,addressFull,cityName,stateName,zipCode,phnNumber;
            System.out.println("Enter the firstname,lastname,address,city,state,zip and phone number");
            fName = sc.next();
            lName = sc.next();
            addressFull = sc.next();
            cityName = sc.next();
            stateName = sc.next();
            zipCode = sc.next();
            phnNumber = sc.next();
            if(!book2.checkDuplicate(fName+lName)) {
                book2.addContact(fName, lName, addressFull, cityName, stateName, zipCode, phnNumber);
            }
        }
        String searchfirstName,searchlastName;
        System.out.println("Enter the first name and last name you want to edit: ");
        searchfirstName = sc.next();
        searchlastName = sc.next();
        book2.searchContact(searchfirstName+searchlastName);
        System.out.println("Enter the first name and last name you want to delete: ");
        searchfirstName = sc.next();
        searchlastName = sc.next();
        book2.deleteContact(searchfirstName,searchlastName);
        System.out.println("Details of all contacts : ");
        book2.displayAllContacts();
    }
}