import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String AdminfileName = "Admin.txt";
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("\u001B[41m" + "       WELCOME TO THE JAVA HOSTEL              " + "\u001B[0m");
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.println("enter\n1 for admin access\n2 for new student\n3 for hostelite\n");
        int opt1 = input.nextInt();
        if (opt1 == 1) {
            System.out.println("Welcome to the admin menu ");
            Admin a1 = new Admin();
            System.out.println("enter the username ");
                String username = input.next();
                System.out.println("enter the password ");
                String password = input.next();
                boolean check = Person.signin(username, password, AdminfileName);
                if (check) {
                    a1.Adminfunctions(username);
                } else {
                    System.out.println("your username or password is not correct ");
                }
        } else if (opt1 == 2) {
            Student s1 = new Student();
            s1.newstudentData();
        } else if (opt1 == 3) {
            Student s2 = new Student();
            s2.oldstudentFunctions();
        }

    }

}
