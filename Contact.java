package oop.Challenge;

import java.util.ArrayList;

public class Contact {
      private String name;
      private int phone;
      private String email;
      private ArrayList<Message>message;

    public Contact(String name, int phone, String email, ArrayList<Message> message) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message = message;
    }

    public Contact(String name, int phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.message=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<Message> message) {
        this.message = message;
    }

    public void getDetails(){
        System.out.println("Name: "+this.name+"\nphone: "+this.phone+"\nemail: "+this.email);
    }
}
