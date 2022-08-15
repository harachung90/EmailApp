package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "abccompany.com";

    //constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //call a method asking for the department - return the department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your email is " + email);
    }

    //ask for the department
    private String setDepartment() {
        System.out.println("New employee: " + firstName + "\nDepartment Codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) { return "sales"; }
        else if (deptChoice == 2) { return "dev"; }
        else if (deptChoice == 3) { return "acc"; }
        else { return ""; }
    }

    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity (int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail (String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailBoxCapacity + "mb";
    }

}
