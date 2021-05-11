package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBookManager {
   public static   Map<String, List<Contact>> addressBookMap = new HashMap<>();
      Scanner readFromUser = new Scanner(System.in);
      AddressBookMain addressBookMain = new AddressBookMain();

    public  void createMultipleAddressBook() {
        Scanner readNameFromUser = new Scanner(System.in);
        System.out.println("How many addressBook you want to create:");
        int numberOfAddressBook = readNameFromUser.nextInt();


        for (int addressBookNumber = 1; addressBookNumber <= numberOfAddressBook; addressBookNumber++) {
            List<Contact> addressBook = new ArrayList<Contact>();
            System.out.println("Enter addressBook name:");
            String addressBookName = readNameFromUser.next();
           try {
               if(addressBookMap.get(addressBookName).isEmpty()) {
                   addressBookMap.put(addressBookName, addressBook);
               }
           }catch (NullPointerException e){
               addressBookMap.put(addressBookName, addressBook);
           }
        }

        addressBookMap.entrySet().forEach(element -> {
            System.out.println(element.getKey() + "=" + element.getValue());
        });
        addressBookMain.addressBookOperation();
    }

    /** @createAddressBook method is used for creating new AddressBook
     *
     * @param addressBookName
     */
    public   void createAddressBook(String addressBookName) {
        Contact person = new Contact();
        System.out.println("Enter First Name:");
        String firstName = readFromUser.next();
        person.setFirstName(firstName);
        System.out.println("Enter Last Name:");
        String lastName = readFromUser.next();
        person.setLastName(lastName);
        System.out.println("Enter Address:");
        String address = readFromUser.next();
        person.setAddress(address);
        System.out.println("Enter City:");
        String city = readFromUser.next();
        person.setCity(city);
        System.out.println("Enter state:");
        String state= readFromUser.next();
        person.setState(state);
        System.out.println("Enter zip:");
        int zip= readFromUser.nextInt();
        person.setZip(zip);
        System.out.println("Enter mobile number:");
        long mobileNumber= readFromUser.nextLong();
        person.setMobileNumber(mobileNumber);
        System.out.println("Enter email:");
        String email= readFromUser.next();
        person.setEmail(email);
        addressBookMap.get(addressBookName).add(person);
    }

    /**
     * @ addNewPerson method is used to add contacts into perticular addressbook
     */
    public void addNewPerson() {
        System.out.println("Enter addressBook name in which you can add person:");
        String addressBookName = readFromUser.next();

        System.out.println("Enter how many contact you want to add");
        int numberOfContacts = readFromUser.nextInt();

        int firstContact = 1;
        for (int contactNumber = firstContact; contactNumber <= numberOfContacts; contactNumber++) {
          createAddressBook(addressBookName);
        }

        addressBookMap.entrySet().forEach(element -> {
            System.out.println(element.getKey() + "=" + element.getValue());
        });
        addressBookMain.addressBookOperation();
    }

    /** @editContact method is used for edit contact
     *
     */
    public void editContact(String addressBookName) {
        System.out.println("Enter person Name:");
        String personName = readFromUser.next();
        Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (personName.equals(contact.getFirstName())) {
                    System.out.println("------Which Detail you want to Edit---------");
                    System.out.println("1:Edit First Name\n2:Edit Last Name\n3:Edit Address\n4:Edit City\n" +
                            "5:Edit State\n6:Edit Zip\n7: Edit Mobile Number\n8:Edit Email");
                    int editChoice = readFromUser.nextInt();

                    switch (editChoice) {
                        case 1:
                            System.out.println("Enter New First Name:");
                            String firstName = readFromUser.next();
                            contact.setFirstName(firstName);
                            break;
                        case 2:
                            System.out.println("Enter New Last Name:");
                            String lastName = readFromUser.next();
                            contact.setLastName(lastName);
                            break;
                        case 3:
                            System.out.println("Enter New Address:");
                            String address = readFromUser.next();
                            contact.setAddress(address);
                            break;
                        case 4:
                            System.out.println("Enter New City Name:");
                            String city = readFromUser.next();
                            contact.setCity(city);
                            break;
                        case 5:
                            System.out.println("Enter New State Name:");
                            String state = readFromUser.next();
                            contact.setState(state);
                            break;
                        case 6:
                            System.out.println("Enter New Zip:");
                            int zip = readFromUser.nextInt();
                            contact.setZip(zip);
                            break;
                        case 7:
                            System.out.println("Enter New Mobile Number:");
                            long mobileNumber = readFromUser.nextLong();
                            contact.setMobileNumber(mobileNumber);
                            break;
                        case 8:
                            System.out.println("Enter New Email:");
                            String email = readFromUser.next();
                            contact.setEmail(email);
                            break;
                    }
                }
            }

            addressBookMap.entrySet().forEach(element -> {
                System.out.println(element.getKey() + "=" + element.getValue());
            });
            addressBookMain.addressBookOperation();
    }

    /** @deleteContact method is used to delete contact
     *
     */
    public void deleteContact(String addressBookName) {
        System.out.println("enter a name to delete contact");
        String name = readFromUser.next();
        Iterator<Contact> iterator = addressBookMap.get(addressBookName).iterator();
        while (iterator.hasNext()) {
            Contact person = iterator.next();
            if (name.equals(person.getFirstName())) {
                addressBookMap.get(addressBookName).remove(person);
                System.out.println("deleted successfully");
                addressBookMap.entrySet().forEach(element -> {
                    System.out.println(element.getKey() + "=" + element.getValue());
                });
                addressBookMain.addressBookOperation();
                return;
            }
        }

    }

    /** @searchPersonByCity is used for find person by city
     *
     */
    public void searchPersonByCity(String addressBookName) {
        System.out.println("Enter CityName:");
        String cityName = readFromUser.next();

        Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
        while (iterator.hasNext()) {
            Contact person = iterator.next();
            if(cityName.equals(person.getCity())) {
                System.out.println(person.getFirstName());
            }
        }
        addressBookMain.addressBookOperation();
    }

    /** @searchPersonByState method is for find person by state
     *
     */
    public void searchPersonByState(String addressBookName) {
        System.out.println("Enter StateName:");
        String StateName = readFromUser.next();

        Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
        while (iterator.hasNext()) {
            Contact person = (Contact) iterator.next();
            if(StateName.equals(person.getState())) {
                System.out.println(person.getState());
            }
        }
        addressBookMain.addressBookOperation();
    }

    /**@countPersonByCity method is used for count person
     *
     */
    public void countPersonByCity(String addressBookName) {
        System.out.println("Enter CityName:");
        String cityName = readFromUser.next();
        int count=0;

        Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
        while (iterator.hasNext()) {
            Contact person = iterator.next();
            if(cityName.equals(person.getCity())) {
                count++;
            }
        }
        System.out.println("Number of person in "+cityName+"="+count);
        addressBookMain.addressBookOperation();
    }

    /** @sortByAlphabetically method is used for alphabetically sorting data  by firstNam
     *
     */
    public void sortByAlphabetically(String addressBookName) {
        List<Contact> sortedAddressBook = (ArrayList<Contact>) addressBookMap.get(addressBookName).stream()
                .sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
        sortedAddressBook.forEach(System.out::println);
        addressBookMain.addressBookOperation();
    }

    /** @sortPersonByCity method is used for sort data by city
     *
     */
    public void sortPersonByCity(String addressBookName) {
        List<Contact> sortAddressBook = (ArrayList<Contact>) addressBookMap.get(addressBookName).stream().sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
        sortAddressBook.forEach(System.out::println);
        addressBookMain.addressBookOperation();
    }

    /** @sortPersonByState method is used for sort data by State
     *
     */
    public void sortPersonByState(String addressBookName) {
        List<Contact> sortAddressBook = (ArrayList<Contact>) addressBookMap.get(addressBookName).stream().sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
        sortAddressBook.forEach(System.out::println);
        addressBookMain.addressBookOperation();
    }

    /** @sortPersonByZip method is used for sort data by Zip
     *
     */
    public void sortPersonByZip(String addressBookName) {
        List<Contact> sortAddressBook = (ArrayList<Contact>) addressBookMap.get(addressBookName).stream().sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
        sortAddressBook.forEach(System.out::println);
        addressBookMain.addressBookOperation();
    }
}
