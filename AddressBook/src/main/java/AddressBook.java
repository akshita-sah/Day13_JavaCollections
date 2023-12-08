import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class AddressBook {
    Map<String,Contact>AddressMap;
    Map<String,ArrayList<Contact>>CityMap;
    Map<String,ArrayList<Contact>>stateMap;

    AddressBook()
    {
        AddressMap = new HashMap<>();
        CityMap = new HashMap<>();
        stateMap = new HashMap<>();
    }

    /* To add a contact we create an object of contact and pass its values to parameterized constructor.
    We keep three maps, for storing contacts according to name, city and state.*/
    void addContact(String fname,String lname,String addressFull,String cityName, String stateName,String zipCode, String phoneNumber)
    {
        Contact c = new Contact(fname,lname,addressFull,cityName,stateName,zipCode,phoneNumber);
        AddressMap.put(fname+lname,c);
        if(CityMap.get(cityName) == null) {
            CityMap.put(cityName, new ArrayList<>());
            CityMap.get(cityName).add(c);
        }
        else
            CityMap.get(cityName).add(c);
        if(stateMap.get(stateName) == null) {
            stateMap.put(stateName, new ArrayList<>());
            stateMap.get(stateName).add(c);
        }
        else
            stateMap.get(stateName).add(c);
        c.display();
    }

    /* To edit the contact first it is searched. Then using switch case the value is
    changed according to choice.*/
    void editContact(String searchName)
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
            return false;
        }
        else return true;
    }
    void searchCity(String city)
    {
        if(CityMap.get(city)!=null) {
            ArrayList<Contact> p = CityMap.get(city);
            System.out.println("The contacts for city "+city+" are: ");
            for(int i=0;i<p.size();i++)
            {
                Contact c = p.get(i);
                c.display();
            }
        }
        else {
            System.out.println("The city does not exist");
        }
    }

    void searchState(String state)
    {
        if(stateMap.get(state)!=null) {
            ArrayList<Contact> p = stateMap.get(state);
            System.out.println("The contacts for state "+state+" are: ");
            for(int i=0;i<p.size();i++)
            {
                Contact c = p.get(i);
                c.display();
            }
        }
        else
            System.out.println("The state does not exist");
    }

    void getCountCity(String city)
    {
        if(CityMap.get(city)!=null) {
            ArrayList<Contact> p = CityMap.get(city);
            System.out.println("The number of contacts for city "+city+" are: " + p.size());
        }
        else {
            System.out.println("The city does not exist");
        }
    }

    void getCountState(String state)
    {
        if(stateMap.get(state)!=null) {
            ArrayList<Contact> p = stateMap.get(state);
            System.out.println("The number of contacts for city "+state+" are: " + p.size());
        }
        else {
            System.out.println("The city does not exist");
        }
    }

    void displayAllContacts()
    {
        for(String name : AddressMap.keySet())
        {
            Contact c = AddressMap.get(name);
            c.display();
        }
    }
}