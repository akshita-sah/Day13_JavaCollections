import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        System.out.println("Welcome to Address Book");
        Scanner sc = new Scanner(System.in);
        int n;
        Dictionary<String,AddressBook> AddressBookList = new Hashtable<>();
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
            else {
                System.out.println("Duplicate Contact, enter again!");
            }
        }
        String searchfirstName,searchlastName;
        System.out.println("Enter the first name and last name you want to edit: ");
        searchfirstName = sc.next();
        searchlastName = sc.next();
        book2.editContact(searchfirstName+searchlastName);
        System.out.println("Enter the first name and last name you want to delete: ");
        searchfirstName = sc.next();
        searchlastName = sc.next();
        book2.deleteContact(searchfirstName,searchlastName);
        System.out.println("Details of all contacts : ");
        book2.displayAllContacts();
        book2.searchCity("jsr");
        book2.searchState("bihar");
    }
}
