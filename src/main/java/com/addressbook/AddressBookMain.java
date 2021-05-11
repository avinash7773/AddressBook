package com.addressbook;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
   static AddressBookManager addressBookManager = new AddressBookManager();
   static FileService fileService = new FileService();


    public static void main(String[] args) {
        AddressBookMain addressBookMain = new AddressBookMain();
        Scanner selectNumber = new Scanner(System.in);

        addressBookMain.addressBookOperation();
    }

    /** @addressBookOperation method is used to perform operations on addressBook
     *
     */
    public void addressBookOperation()  {
        Scanner selectOperationNumber = new Scanner(System.in);
        System.out.println("------OperationOnAddressBook---------");
        System.out.println("1: Creat AddressBook\n2: Add Person\n3 : Edit Person\n" +
                "4: Delete Contact\n5: searchPersonByCity\n6: searchPersonByCity\n" +
                "7: CountPersonByCity\n8: sortByAlphabetically\n9: sortPersonByCity\n" +
                "10: sortPersonByState\n11: sortPersonByZip\n12: write data into file\n13: Delete File\n14: close program");
        int number = selectOperationNumber.nextInt();
        switch (number) {
            case 1:
                addressBookManager.createMultipleAddressBook();
                break;
            case 2:
                addressBookManager.addNewPerson();
                break;
            case 3:
                System.out.println("Enter AddressBook Name for edit Contact :");
                String name = selectOperationNumber.next();
                addressBookManager.editContact(name);
                break;
            case 4:
                System.out.println("Enter AddressBook Name for delete Contact :");
                String nameForDeleting = selectOperationNumber.next();
                addressBookManager.deleteContact(nameForDeleting);
                break;
            case 5:
                System.out.println("Enter AddressBook Name for search PersonBy City :");
                String personName = selectOperationNumber.next();
                addressBookManager.searchPersonByCity(personName);
                break;
            case 6:
                System.out.println("Enter AddressBook Name for search PersonBy State:");
                String personNameForSearchState = selectOperationNumber.next();
                addressBookManager.searchPersonByCity(personNameForSearchState);
                break;
            case 7:
                System.out.println("Enter AddressBook Name for Count PersonBy City:");
                String personNameForCount = selectOperationNumber.next();
                addressBookManager.searchPersonByCity(personNameForCount);
                break;
            case 8:
                System.out.println("Enter AddressBook Name For sortingAlphabetically:");
                String personNameForSorting = selectOperationNumber.next();
                addressBookManager.sortByAlphabetically(personNameForSorting);
                break;
            case 9:
                System.out.println("Enter AddressBook Name For sortingByCity:");
                String personNameForSortingByCity = selectOperationNumber.next();
                addressBookManager.sortPersonByCity(personNameForSortingByCity);
                break;
            case 10:
                System.out.println("Enter AddressBook Name For sortingByState:");
                String personNameForSortingByState = selectOperationNumber.next();
                addressBookManager.sortPersonByState(personNameForSortingByState);
                break;
            case 11:
                System.out.println("Enter AddressBook Name For sortingByZip:");
                String personNameForSortingByZip = selectOperationNumber.next();
                addressBookManager.sortPersonByCity(personNameForSortingByZip);
                break;
            case 12:
                fileService.writeData();
                System.out.println("Write Data Successfully!!!");
                break;
            case 13:
                fileService.deleteFile();
                break;
            case 14:
                System.out.println("*****THANK YOU******");
                System.out.println("*****PROGRAM END****");
        }
    }
}
