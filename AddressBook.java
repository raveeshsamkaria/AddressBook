import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person
{
    private String name, city, state, address, zipCode;
    private long phoneNumber;
    public Person(String name, String city, String state, String address, String zipCode, long phoneNumber)
    {
        this.name = name;
        this.city = city;
        this.state = state;
        this.address = address;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getState()
    {
        return this.state;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getZipCode()
    {
        return this.zipCode;
    }

    public long getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void showPersonsDetails()
    {
        System.out.println(">--------------------------------------------<");
        System.out.println("\tName            : " +this.getName());
        System.out.println("\tPhone Number    : " +this.getPhoneNumber());
        System.out.println("\tAddress         : " +this.getAddress());
        System.out.println("\tCity            : " +this.getCity());
        System.out.println("\tState           : " +this.getState());
        System.out.println("\tZip Code        : " +this.getZipCode());
        System.out.println(">--------------------------------------------<");
    }
}

public class AddressBook
{
    private ArrayList<Person> data=new ArrayList<Person>();
    public String readString(String displayMessage)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(displayMessage);
        String input=sc.nextLine();
        return input;
    }
    public long readLong(String displayMessage)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print(displayMessage);
        long input=sc.nextLong();
        return input;
    }
    public int indexOfPerson()
    {
        System.out.println();
        String name=readString("-> Enter Name: ");
        long phoneNumber=readLong("-> Enter Phone Number: ");
        int index=0;
        for(Person p : this.data)
        {
            if(p.getName().equals(name) && p.getPhoneNumber()==phoneNumber)
            {
                return index;
            }
            ++index;
        }
        return -1;
    }

    public void addPerson()
    {
        System.out.println();
        String name=readString("-> Enter Name        : ");
        String city=readString("-> Enter City        : ");
        String state=readString("-> Enter State       : ");
        String address=readString("-> Enter Address     : ");
        String zipCode=readString("-> Enter Zip Code    : ");
        long phoneNumber=readLong("-> Phone Number      : ");
        Person newEntry=new Person(name, city, state, address, zipCode, phoneNumber);
        this.data.add(newEntry);
        System.out.println("\n->\t"+name+" Added Successfully...");
    }

    public void editPerson()
    {
        int index=this.indexOfPerson();
        if(index != -1)
        {
            String options="\n-> What You Want To Change?\n\t1. City\n\t2. State\n\t3. Address\n\t4. Zip Code\n\t5. PhoneNumber\n\n-> Enter Option : ";
            int choice=(int)readLong(options);
            switch(choice)
            {
                case 1:     this.data.get(index).setCity(readString("-> Enter New City: "));
                            System.out.println("->\tRecord Modified");
                            break;
                case 2:     this.data.get(index).setState(readString("-> Enter New State: "));
                            System.out.println("->\tRecord Modified");
                            break;
                case 3:     this.data.get(index).setAddress(readString("-> Enter New Address: "));
                            System.out.println("->\tRecord Modified");
                            break;
                case 4:     this.data.get(index).setZipCode(readString("-> Enter New Zip Code: "));
                            System.out.println("->\tRecord Modified");
                            break;
                case 5:     this.data.get(index).setPhoneNumber(readLong("-> Enter New Phone number: "));
                            System.out.println("->\tRecord Modified");
                            break;
                default:    System.out.println("\n->\tInvalid Option Selected...");
            }
        }
        else
            {
            System.out.println("\n->\tNo Record Founded...!!!");
            }
    }

    public void deletePerson()
    {
        int index=this.indexOfPerson();
        if(index != -1)
            {
                Person p=this.data.remove(index);
                System.out.println("\n->\tRecord of Person "+p.getName()+" with Phone Number "+p.getPhoneNumber()+" Removed Successfully...");
            }
        else
            {
                System.out.println("\n->\tNo Record Founded...!!!");
            }
    }

    public void sortByName()
    {
        Collections.sort(this.data, (person1, person2) -> (person1.getName().compareTo(person2.getName())));
        System.out.println("\n->\tRecords Sorted By Name Successfully...");
    }

    public void sortByZip()
    {
        Collections.sort(this.data, (person1, person2) -> (person1.getZipCode().compareTo(person2.getZipCode())));
        System.out.println("\n->\tRecords Sorted By Zip Code Successfully...");
    }

    public void showPerson()
    {
        int index=this.indexOfPerson();
        if(index != -1)
            {
                this.data.get(index).showPersonsDetails();
            }
        else
            {
                System.out.println("\n->\tNo Record Founded...!!!");
            }
    }

    public void showAllPersons()
    {
        for(Person p : this.data)
        {
            p.showPersonsDetails();
        }
        if(this.data.isEmpty())
            {
                System.out.println("\n\n->\t\tAddress Book Is Empty!\t\t\n");
            }
    }

    public void menu()
    {
        long choice=-1;
        while(choice != 0)
        {
            System.out.println();
            System.out.println(">-----------< Address Book Manager >-----------<");
            System.out.println("-> 1. Add a Person");
            System.out.println("-> 2. Edit a Person");
            System.out.println("-> 3. Delete a Person");
            System.out.println("-> 4. Sort Address Book by Name Field");
            System.out.println("-> 5. Sort Address Book by Zip Code Field");
            System.out.println("-> 6. Show a Person");
            System.out.println("-> 7. Show All Persons");
            System.out.println("-> 8. Exit");
            System.out.println(">----------------------------------------------<");
            choice=readLong("-> Enter Your Choice : ");

            switch((int)choice)
            {
                case 1: addPerson();
                    break;
                case 2: editPerson();
                    break;
                case 3: deletePerson();
                    break;
                case 4: sortByName();
                    break;
                case 5: sortByZip();
                    break;
                case 6: showPerson();
                    break;
                case 7: showAllPersons();
                    break;
                case 8: choice = 0;
                    break;
                default: System.out.println("\n->\tInvalid Choice...!!!");
            }
        }
    }

    public static void main(String[] args)
    {
        AddressBook add=new AddressBook();
        add.menu();
    }
}
