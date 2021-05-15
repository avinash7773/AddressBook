package com.addressbook;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileService  extends AddressBookManager{
    Scanner scannerObject = new Scanner(System.in);
    static String path = "C:/Users/Admin/IdeaProjects/AddressBook/src/resources";

    public void writeData()  {
        BufferedWriter bufferedWriter = null;

        /**
        * create files
       */
        System.out.println("Enter File Name:");
        String fileName = scannerObject.next();
        String tempFile = path+"/"+fileName;
        if(Files.exists(Path.of(tempFile))) {
            /** writeData intoFile
             *
             */
            File file = new File(tempFile);
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                for (Map.Entry<String, List<Contact>> stringListEntry : addressBookMap.entrySet()) {
                    bufferedWriter.write(stringListEntry.getKey() + ":" + stringListEntry.getValue());
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createFile(Path.of(tempFile));
                /** writeData intoFile
                 *
                 */
                File file = new File(tempFile);
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    for (Map.Entry<String, List<Contact>> stringListEntry : addressBookMap.entrySet()) {
                        bufferedWriter.write(stringListEntry.getKey() + ":" + stringListEntry.getValue());
                        bufferedWriter.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                return;
            }
        }

        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addressBookMain.addressBookOperation();
    }

    /** @deleteFile method is used for deleting file
     *
     */
    public void deleteFile() {
        System.out.println("Enter fileName for delete file:");
        String fileName = scannerObject.next();
        Path tempFile = Paths.get(path+"/"+fileName);
        try {
            if(Files.deleteIfExists(tempFile)) {
                System.out.println("file deleted successfully");
            }
        } catch (IOException e) {
            System.out.println("file not present");
        }
        addressBookMain.addressBookOperation();
    }

    /** @writeCSVFile method is used for write data into csv formate
     *
     * @param addressBookName
     */
    public void writeCSVFile(String addressBookName) {
        System.out.println("Enter CSV File Name");
        String fileName = scannerObject.next();
        Path tempCSVFile = Paths.get(path+"/"+fileName);
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(String.valueOf(tempCSVFile)));
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Contact.class);
            String[] memberFieldsToBindTo = {"firstname", "lastName","address", "city","state","zip", "mobileNumber", "email"};
            strategy.setColumnMapping(memberFieldsToBindTo);
            StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withMappingStrategy(strategy).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

            Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
            while (iterator.hasNext()) {
                Contact person = iterator.next();
                beanToCsv.write(person);
            }
            writer.close();
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ioException) {
            ioException.printStackTrace();
        }
        addressBookMain.addressBookOperation();
    }

    public void writeJSONFile(String addressBookName) {
        System.out.println("Enter json File Name");
        String fileName = scannerObject.next();
        Path tempCSVFile = Paths.get(path+"/"+fileName);
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(String.valueOf(tempCSVFile)));
            Iterator<Contact> iterator = addressBookMap.get(addressBookName).stream().iterator();
            while (iterator.hasNext()) {
                Contact person = iterator.next();
                jsonObject.put("FirstName:",person.getFirstName());
                jsonObject.put("LastName: ",person.getLastName());
                jsonObject.put("Address:",person.getAddress()) ;
                jsonObject.put("City:",person.getCity());
                jsonObject.put("State:",person.getState());
                jsonObject.put("Zip:",person.getZip());
                jsonObject.put("MobileNumber:",person.getMobileNumber());
                jsonObject.put("Email:",person.getEmail());
            }
            writer.write(jsonObject.toString());
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}

