package com.addressbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileService  extends AddressBookManager{
    Scanner scannerObject = new Scanner(System.in);
    static String path = "C:/Users/Admin/IdeaProjects/AddressBook/src/resources";

    public void writeData()  {
        /**
        * create files
       */
        System.out.println("Enter File Name:");
        String fileName = scannerObject.next();
        String tempFile = path+"/"+fileName;
        try {
            Files.createFile(Path.of(tempFile));
        }catch (IOException e) {
            return;
        }

        /** writeData intoFile
         *
         */
        File file = new File(tempFile);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, List<Contact>> stringListEntry : addressBookMap.entrySet()) {
                bufferedWriter.write(stringListEntry.getKey() + ":" + stringListEntry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addressBookMain.addressBookOperation();
    }

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
    }
}

