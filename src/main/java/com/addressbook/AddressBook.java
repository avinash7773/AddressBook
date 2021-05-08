package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    List addressBook = new ArrayList<>();
    Scanner readFromUser = new Scanner(System.in);

    /** @contactDetail method is used to add contact detail
     *
     */
    public void contactDetail(){
        List<String> contact = new ArrayList<>();
        System.out.println("Enter First Name:");
        String first_Name = readFromUser.next();
        contact.add(first_Name);
        System.out.println("Enter Last Name:");
        String last_Name = readFromUser.next();
        contact.add(last_Name);
        System.out.println("Enter Address:");
        String address = readFromUser.next();
        contact.add(address);
        System.out.println("Enter City:");
        String city = readFromUser.next();
        contact.add(city);
        System.out.println("Enter state:");
        String state= readFromUser.next();
        contact.add(state);
        System.out.println("Enter zip:");
        String zip= readFromUser.next();
        contact.add(zip);
        System.out.println("Enter mobile number:");
        String mobile_number= readFromUser.next();
        contact.add(mobile_number);
        System.out.println("Enter email:");
        String email= readFromUser.next();
        contact.add(email);
        addressBook.add(contact);
    }

    /**
     * @ addContact method is used to add contacts into addressbook
     */
    public void addContact(){
        System.out.println("Enter how many contact you want to add");
        int number_of_contacts = readFromUser.nextInt();
        int first_contact=1;
        for (int contactNumber =first_contact; contactNumber <= number_of_contacts; contactNumber++ ) {
            contactDetail();
        }
        System.out.println(addressBook);
    }
}
