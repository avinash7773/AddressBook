package com.addressbook;

import java.awt.*;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.contactDetail();
        addressBook.addContact();
        addressBook.editContact();
        addressBook.deleteContact();
        addressBook.multipleAddressBook();
        addressBook.searchPersonByCity();
        addressBook.searchPersonByState();
    }
}
