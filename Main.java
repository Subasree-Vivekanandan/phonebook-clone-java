package oop.Challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Contact>contacts;
    public static Scanner sc;
    public static int id =0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to phonebook & message application\n-----------------------------------------");

        showInitOptions();

    }
    public static void showInitOptions(){
        System.out.println("Choose any one: \n\t1. Manage Contact\n\t2. Manage messages \n\t3. Quit");
        sc=new Scanner(System.in);
        int choice=sc.nextInt();

        switch (choice) {
            case 1:
                managecontact();
                break;
            case 2:
                showmessages();
                break;
            case 3:
                break;
        }

    }

    public static void managecontact(){
        System.out.println("Choose any one : \n\t1. Show all contacts\n\t2. Add a new contact \n\t3. Search for a contact\n\t4. Delete a contact\n\t5. Go back to the previous menu");
        int choice=sc.nextInt();
        switch (choice){
            case 1:
                showallContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                SearchContact();
                break;
            case 4:
                DeleteContact();
                break;
            case 5:
                showInitOptions();

        }

    }

    public static synchronized void showallContacts(){
        if(contacts.size() >0) {
            for (Contact c : contacts) {
                c.getDetails();
                System.out.println("--------------------------------");
            }
        }
        else {
                System.out.println("No contacts found");
                showInitOptions();
            }

        showInitOptions();
    }

    public static synchronized void addContact() {
        System.out.println(("Enter the name : "));
        String name = sc.next();
        System.out.println(("Enter phone number: "));
        int phone = sc.nextInt();
        System.out.println("Enter email : ");
        String email = sc.next();

        if (name.equals("") || (phone == 0) || email.equals("")) {
            System.out.println("enter valid details");
            showInitOptions();
        } else {
            boolean ifpresent = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    ifpresent = true;
                }
            }
            if (ifpresent) {
                System.out.println("Contact with name " + name + " already exists");
                addContact();
            } else {
                Contact newcontact = new Contact(name, phone, email);
                System.out.println("Contact added ");
                contacts.add(newcontact);
            }
        }
        showInitOptions();
    }


    public static synchronized void SearchContact(){
        System.out.println("Enter name of the contact to be searched : ");
        String name = sc.next();
        if(name.equals("")){
            System.out.println("invalid name");
            SearchContact();
        }
        else{
            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist =true;
                    System.out.println("Contact matched");
                    c.getDetails();
                }
            }

            if(!doesExist){
                System.out.println("Name does not exist");
            }
        }
        showInitOptions();
    }

    public static synchronized void DeleteContact(){
        System.out.println("Enter name to delete :");
        String name =sc.next();

        if(name.equals("")){
            System.out.println("Enter valid name ");
            DeleteContact();
        }
        else{
            boolean ispresent = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    ispresent = true;
                    contacts.remove(c);
                    System.out.println("Contact deleted successfully");
                }
            }
            if(!ispresent){
                System.out.println("No contact matched");
            }
        }
        showInitOptions();
    }

    public static void showmessages(){
        System.out.println("Choose any one: \n\t1.See list of all messages" +
                "\n\t2.Send a new message"+"\n\t3.Go back to previous list");

        int choice =sc.nextInt();
        switch (choice){
            case 1:
                seeListMsgs();
                break;
            case 2:
                SendMsg();
                break;
            case 3:
                showInitOptions();
                break;
        }
    }

    public static synchronized void seeListMsgs(){
        ArrayList<Message> allmsgs = new ArrayList<>();
        for(Contact c: contacts){
            allmsgs.addAll(c.getMessage());
        }
        if(allmsgs.size() > 0){
            for(Message m: allmsgs){
                m.getDetails();
                System.out.println("------------------------------------");
            }
        }
        else {
            System.out.println("No messages found");
        }
        showInitOptions();
    }

    public static synchronized void SendMsg(){
        System.out.println("Enter the recipient name to send the message ");
        String recipientName = sc.next();
        if(recipientName.equals("")){
            System.out.println("Enter valid name");
            showInitOptions();
        }
        else {
            boolean iffound = false;
            for (Contact c : contacts) {
                if (c.getName().equals(recipientName)) {
                    iffound = true;
                }
            }
            if(iffound){
                System.out.println("Enter message to be sent");
                String text = sc.next();
                if(text.equals("")){
                    System.out.println("Enter valid message ");
                    showInitOptions();
                }
                else{
                    id++;
                    Message newmsg = new Message(text,recipientName,id);
                    for(Contact c:contacts){
                        if(c.getName().equals(recipientName)){
                            ArrayList<Message> newmsgs = c.getMessage();
                            newmsgs.add(newmsg);
                            c.setMessage(newmsgs);
                            System.out.println("Message sent to "+recipientName);
                        }
                    }
                }
            }
        }
        showInitOptions();
    }
}
