import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin extends Person {
    private int salary;
    private String username;
    private String password;
    Scanner input = new Scanner(System.in);
    public Admin() {
        super();
        this.salary = 0;
        this.username = null;
        this.password = null;
    }

    public Admin(String name, int age, String phoneNumber, String id, int salary, String username, String password) {
        super(name, age, phoneNumber, id);
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Adminfunctions(String username) {
        String AdminfileName = "Admin.txt";
        String StudentfileName = "studentdata.text";
        System.out.println("you have successfully enter into admin controls ");
        System.out.println();
        System.out.println("enter\n1 for changing password \n2 for seeing student details");
        System.out.println("3 for searching specific student\n4 for seeing rooms of hostel");
        int opt3 = input.nextInt();
        switch (opt3) {
            case 1:
                System.out.println("enter the password ");
                String newpassword = input.next();
                changpassword(username, newpassword, AdminfileName);
                break;
            case 2:
                String studentFilePath1 = "studentdata.text";
                viewingStudents(studentFilePath1);
                break;
            case 3:
                System.out.println("enter the cnic number of student ");
                String cnic = input.next();
                specificcnic(cnic, StudentfileName);
                break;
            case 4:
                Rooms.hostelrooms();
                break;

        }
    }

    public void Admindetail() {
        System.out.println("Admin name = " + getName());
        System.out.println("Admin age = " + getAge());
        System.out.println("Admin phonenumber = " + getPhoneNumber());
    }
    // for changing username and password of admin file

    public void changpassword(String username, String newpassword, String path) {
        Scanner x;
        File filepath = new File(path);
        String temfile = "temfile.text";
        File newfile = new File(temfile);
        String tempuername = "";
        String temppassword = "";
        try {
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(path));
            while (x.hasNext()) {
                tempuername = x.next();
                temppassword = x.next();
                if (tempuername.trim().equals(username.trim()))
                    pw.println(tempuername + " " + newpassword);
                else
                    pw.println(tempuername + " " + temppassword);

            }
            x.close();
            pw.flush();
            pw.close();
            filepath.delete();
            File dump = new File(path);
            newfile.renameTo(dump);
        } catch (Exception e) {
            System.out.println("Error in login file");
        }
    }
    // for searching the specific student in the hostel

    public void specificcnic(String cnic, String filepath) {
        Scanner x;
        String tempcnic = "";
        String temproom = "";
        String tempname = "";
        String tempphone = "";
        String tempjob = "";
        String tempfee = "";
        try {
            x = new Scanner(new File(filepath));
            while (x.hasNext()) {
                tempcnic = x.next();
                temproom = x.next();
                tempname = x.next();
                tempphone = x.next();
                tempjob = x.next();
                tempfee = x.next();
                if (tempcnic.trim().equals(cnic)) {
                    System.out.print(
                            "STUDENT CNIC: " + tempcnic + " ROOM NO: " + temproom + " STUDENT NAME: " + tempname);
                    System.out.println(" PHONE NO: " + tempphone + " JOB: " + tempjob + " STUDENT FEE: " + tempfee);
                }
            }
            x.close();

        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // for deleting hostelite from the hostelite file
    public static void deletestudent(String cnic, String path) {
        Scanner x;
        String room = "";
        File filepath = new File(path);
        String temfile = "temfile.text";
        File newfile = new File(temfile);
        String tempcnic = "";
        String temproom = "";
        String tempname = "";
        String tempphone = "";
        String tempjob = "";
        String tempfee = "";
        try {
            FileWriter fw = new FileWriter(newfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(path));
            while (x.hasNext()) {
                tempcnic = x.next();
                temproom = x.next();
                tempname = x.next();
                tempphone = x.next();
                tempjob = x.next();
                tempfee = x.next();
                if (tempcnic.trim().equals(cnic.trim())) {
                    room = temproom;
                } else {
                    pw.println(tempcnic + " " + temproom + " " + tempname + " " + tempphone + " " + tempjob + " "
                            + tempfee);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            filepath.delete();
            File dump = new File(path);
            newfile.renameTo(dump);

            // after getting the room we change room from booked to empty by its length
            // if length is 6 means it is from first floor
            if (room.length() == 6) {
                String temfile1 = "tem.txt";
                File oldfile1 = new File("floor1.text");
                File newfile1 = new File(temfile1);
                String temproom1 = "";
                String tempfloor = "";
                String empty = "";
                String leave = "empty";

                try {
                    FileWriter fw1 = new FileWriter(temfile1, true);
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    PrintWriter pw1 = new PrintWriter(bw1);
                    x = new Scanner(new File("floor1.text"));
                    while (x.hasNext()) {
                        temproom = x.next();
                        tempfloor = x.next();
                        empty = x.next();
                        if (temproom.equals(room)) {
                            pw1.println(temproom + " " + tempfloor + " " + leave);
                        } else {
                            pw1.println(temproom + " " + tempfloor + " " + empty);
                        }
                    }
                    x.close();
                    pw1.flush();
                    pw1.close();
                    oldfile1.delete();
                    File dump1 = new File("floor1.text");
                    newfile1.renameTo(dump1);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            // if length is 4 mean that it is from second floor

            else if (room.length() == 4) {
                String temfile2 = "tem.txt";
                File oldfile2 = new File("floor2.text");
                File newfile2 = new File(temfile2);
                String temproom2 = "";
                String tempfloor = "";
                String empty = "";
                String leave2 = "empty";

                try {
                    FileWriter fw2 = new FileWriter(temfile2, true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    PrintWriter pw2 = new PrintWriter(bw2);
                    x = new Scanner(new File("floor2.text"));
                    while (x.hasNext()) {
                        temproom2 = x.next();
                        tempfloor = x.next();
                        empty = x.next();
                        if (temproom2.equals(room)) {
                            pw2.println(temproom2 + " " + tempfloor + " " + leave2);
                        } else {
                            pw2.println(temproom2 + " " + tempfloor + " " + empty);
                        }
                    }
                    x.close();
                    pw2.flush();
                    pw2.close();
                    oldfile2.delete();
                    File dump2 = new File("floor2.text");
                    newfile2.renameTo(dump2);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else
                System.out.println("The sequence in the student file is wrong or incorrect ");
        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void viewingStudents(String filepath) {
        Scanner x;
        String tempcnic = "";
        String temproom = "";
        String tempname = "";
        String tempphone = "";
        String tempjob = "";
        String tempfee = "";
        try {
            x = new Scanner(new File(filepath));
            while (x.hasNext()) {
                tempcnic = x.next();
                temproom = x.next();
                tempname = x.next();
                tempphone = x.next();
                tempjob = x.next();
                tempfee = x.next();
                System.out.print("STUDENT CNIC: " + tempcnic + " ROOM NO: " + temproom + " STUDENT NAME: " + tempname);
                System.out.println(" PHONE NO: " + tempphone + " JOB: " + tempjob + " STUDENT FEE: " + tempfee);
            }
        } catch (IOException e) {
            System.out.println("Error in student file occured ");
        } catch (Exception ex) {
            System.out.println("Error in file data occured ");
        }
    }
}
