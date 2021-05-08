package com.addressbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    List<Contact> addressBook = new ArrayList<>();
    Scanner readFromUser = new Scanner(System.in);

    /** @contactDetail method is used to add contact detail
     *
     */
    public void contactDetail() {
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
        addressBook.add(person);
    }

    /**
     * @ addContact method is used to add contacts into addressbook
     */
    public void addContact() {
        System.out.println("Enter how many contact you want to add");
        int numberOfContacts = readFromUser.nextInt();
        int firstContact=1;
        for (int contactNumber =firstContact; contactNumber <= numberOfContacts; contactNumber++ ) {
            contactDetail();
        }
        System.out.println(addressBook);
    }

    /** @editContact method is used for edit contact
     *
     */
    public void editContact() {
        Iterator<Contact> itr = addressBook.iterator();
        System.out.println("Enter name which person you want to edit");
        String name = readFromUser.next();
        while (itr.hasNext()) {
            Contact person = (Contact) itr.next();
            if (name.equals(person.getFirstName())) {
                System.out.println("you can edit");
                System.out.println("1/edit first name," +
                        "2/edit lastname," +
                        "3/edit address" +
                        "4/edit city," +
                        "5/edit state" +
                        "6/edit zip," +
                        "7/edit mobileNumber" +
                        "8/edit email");
                System.out.println("enter a number to edit details");
                int number = readFromUser.nextInt();
                switch (number) {

                    case 1:
                        System.out.println("please suggest firstName");
                        person.firstName = readFromUser.next();
                        System.out.println("implemented firstName: " + person.firstName);
                        break;
                    case 2:
                        System.out.println("please suggest your lastname");
                        person.lastName = readFromUser.next();
                        System.out.println("implemented lastname: " + person.lastName);
                        break;
                    case 3:
                        System.out.println("please suggest your address");
                        person.address = readFromUser.next();
                        System.out.println("implemented PhoneNo: " + person.address);
                        break;
                    case 4:
                        System.out.println("please suggest your City");
                        person.city = readFromUser.next();
                        System.out.println("implemented city: " + person.city);
                        break;
                    case 5:
                        System.out.println("please suggest your State");
                        person.state = readFromUser.next();
                        System.out.println("implemented city: " + person.state);
                        break;
                    case 6:
                        System.out.println("please suggest your Zip");
                        person.zip = readFromUser.nextInt();
                        System.out.println("implemented zip: " + person.zip);
                        break;
                    case 7:
                        System.out.println("please suggest your mobileNumber");
                        person.mobileNumber = readFromUser.nextInt();
                        System.out.println("implemented state: " + person.mobileNumber);
                        break;
                    case 8:
                        System.out.println("please suggest your email");
                        person.email = readFromUser.next();
                        System.out.println("implemented address is: " + person.email);
                        break;
                }
            }
        }
        System.out.println(addressBook);
    }
}
