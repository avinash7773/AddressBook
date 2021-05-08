package com.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    Contact person1 = new Contact();
    Scanner readFromUser = new Scanner(System.in);

    /** @contactDetail method is used to add contact detail
     *
     */
    public void contactDetail(){
        System.out.println("Enter First Name:");
        String first_Name = readFromUser.next();
        person1.setFirst_Name(first_Name);
        System.out.println("Enter Last Name:");
        String last_Name = readFromUser.next();
        person1.setLast_Name(last_Name);
        System.out.println("Enter Address:");
        String address = readFromUser.next();
        person1.setAddress(address);
        System.out.println("Enter City:");
        String city = readFromUser.next();
        person1.setCity(city);
        System.out.println("Enter state:");
        String state= readFromUser.next();
        person1.setState(state);
        System.out.println("Enter zip:");
        int zip= readFromUser.nextInt();
        person1.setZip(zip);
        System.out.println("Enter mobile number:");
        long mobile_number= readFromUser.nextLong();
        person1.setMobile_number(mobile_number);
        System.out.println("Enter email:");
        String email= readFromUser.next();
        person1.setEmail(email);
        System.out.println(person1);
    }
}
