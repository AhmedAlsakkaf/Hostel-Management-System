import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;


class Student extends Person {
    String adress;
    int roomNo;
    Scanner input = new Scanner(System.in);

    public Student() {
        super();
        this.adress = "";
        this.roomNo = 0;
    }

    public Student(String name, int age, String phoneNumber, String id, String adress, int roomNo) {
        super(name, age, phoneNumber, id);
        this.adress = adress;
        this.roomNo = roomNo;
    }

    Scanner scanner = new Scanner(System.in);

    public void newstudentData() {
        System.out.println("welcome to the new student menu ");
        // s1.ReserveRoom();
        System.out.println("\nThere Are six Double Seater Rooms on the First Floor" +
                "\n The fee on that Floor is 15000 PK Rupees for a Double Seater ROOM" +
                "\n There are six Single Seater Rooms on the Second Floor" +
                "\n The Fee on the Floor is 22000 PK Rupees For a Single Seater ROOM");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("the total rooms are  ");

        Rooms.hostelrooms();
        int floorchoice = 0;
        while (true) {
            try {
                System.out.println("\nPlease Enter YOUr choice:" +
                        "\n1: For a double seater Room on the First Floor" +
                        "\n2: For a single Seater Room on the Second Floor");
                System.out.println("------------------------------------------------------------");
                floorchoice = input.nextInt();
                break;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Please Enter again: ");
                input.nextLine();
            }
        }

        System.out.println("Enter the room where you want a seat ");
        boolean roomchoice = false;
        int roomchoose = 0;
        while (!roomchoice) {
            try {
                roomchoose = input.nextInt();
                if (roomchoose >= 1 && roomchoose <= 6)
                    roomchoice = true;
                else
                    System.out.println("Please enter 1 to 6");
            } catch (Exception e) {
                System.out.println("Please enter the correct input ");
                input.nextLine();
            }
        }
        String studentseat = "";
        if (floorchoice == 1) {
            boolean seatchoice = false;
            int seatchoose = 0;
            while (!seatchoice) {
                try {
                    System.out.println("Please enter \n1 for seat no one \n2 for seat no two");
                    seatchoose = input.nextInt();
                    if (seatchoose == 1 || seatchoose == 2) {
                        seatchoice = true;
                    } else
                        System.out.println("Please enter 1 or 2");
                } catch (Exception e) {
                    System.out.println("please enter the integer 1 or 2");
                    input.nextLine();

                }
            }
            if (roomchoose == 1) {
                if (seatchoose == 1) {
                    studentseat = "F1R1S1";
                } else
                    studentseat = "F1R1S2";
            } else if (roomchoose == 2) {

                if (seatchoose == 1) {
                    studentseat = "F1R2S1";
                } else
                    studentseat = "F1R2S2";
            } else if (roomchoose == 3) {
                if (seatchoose == 1) {
                    studentseat = "F1R3S1";
                } else
                    studentseat = "F1R3S2";
            } else if (roomchoose == 4) {
                if (seatchoose == 1) {
                    studentseat = "F1R4S1";
                } else
                    studentseat = "F1R4S2";
            } else if (roomchoose == 5) {
                if (seatchoose == 1) {
                    studentseat = "F1R5S1";
                } else
                    studentseat = "F1R5S2";
            } else if (roomchoose == 6) {
                if (seatchoose == 1) {
                    studentseat = "F1R6S1";
                } else
                    studentseat = "F1R6S2";
            }

        } else if (floorchoice == 2) {
            if (roomchoose == 1)
                studentseat = "F2R1";
            else if (roomchoose == 2) {
                studentseat = "F2R2";
            } else if (roomchoose == 3) {
                studentseat = "F2R3";
            } else if (roomchoose == 4) {
                studentseat = "F2R4";
            } else if (roomchoose == 5) {
                studentseat = "F2R5";
            } else if (roomchoose == 6) {
                studentseat = "F2R6";
            }

        }
        System.out.println(studentseat);
        boolean roomfound = Student.roomavailable(studentseat, floorchoice);
        System.out.println(roomfound);
        String name = "";
        if (roomfound) {
            // for getting details of student
            boolean namecondition = false;
            input.nextLine();
            while (!namecondition) {
                System.out.print("Enter your name ");

                name = input.nextLine();
                System.out.println(name);
                if (name.length() > 2) {
                    boolean namecheck = nameOrprofessioncheck(name);
                    if (namecheck)
                        namecondition = true;
                    else
                        System.out.println("Please enter the alphabets only");
                } else
                    System.out.println("Please enter at least 3 letters");
                System.out.println();
            }
            name = name.replace(" ", "_");

            boolean cniccheck = false;
            String cnic = "";
            while (!cniccheck) {
                try {
                    System.out.println("Enter your CNIC number ");
                    cnic = input.next();
                    boolean correctcard = idchecker(cnic);
                    if (correctcard) {
                        String path1 = "studentdata.text";
                        boolean cnicindata = checkcnic(cnic, path1);
                        if (!cnicindata)
                            cniccheck = true;
                        else
                            System.out.println("This CNIC is present in our system ");
                    } else
                        System.out.println("Please enter the correct CNIC number");
                } catch (Exception e) {
                    System.out.println("Enter the correct CNIC number and must be of length 13 digits ");
                }

            }
            boolean phonenumbercheck = false;
            System.out.println("Enter your phone number ");
            String phone = "";
            while (!phonenumbercheck) {
                phone = input.next();
                boolean phonecheck = phonenumberchecker(phone);
                if (phonecheck) {
                    phonenumbercheck = true;
                } else
                    System.out.println("Please enter the correct phone number");
            }
            boolean jobcondition = false;
            String job = "";
            input.nextLine();
            while (!jobcondition) {
                System.out.print("Enter the your job  ");
                job = input.nextLine();
                if (job.length() > 2) {
                    boolean jobcheck = nameOrprofessioncheck(job);
                    if (jobcheck)
                        jobcondition = true;
                    else
                        System.out.println("Please enter the alphabetS only");
                } else
                    System.out.println("Please enter at least 3 characters");

            }
            job = job.replace(" ", "_");

            // student fee
            String studentfee = "";
            if (floorchoice == 1) {
                System.out.println("Your hostel fee is 15000 per month ");
                studentfee = "15000";
            } else if (floorchoice == 2) {
                System.out.println("Your hostel fee is 22000 per month");
                studentfee = "22000";
            }
            String[] studentdata = { cnic, studentseat, name, phone, job, studentfee };

            // for data entry in the student data file
            newstudentdata(floorchoice, studentdata);
            System.out.println("Your data has been save in the student file");
        } else {
            System.out.println("Sorry this room is already booked");
        }
    }

    public void oldstudentFunctions() {
        System.out.println("welcome to the old student menu ");
        String cnic1 = "";
        String path = "studentdata.text";
        boolean cnicpresent = false;
        while (!cnicpresent) {
            boolean cniccheck1 = false;
            System.out.println("Enter your CNIC number ");
            System.out.print("Enter here... ");
            while (!cniccheck1) {
                try {
                    cnic1 = input.next();
                    boolean correctcard = idchecker(cnic1);
                    if (correctcard) {
                        cniccheck1 = true;
                    } else
                        System.out.println("Please enter the correct CNIC number");
                } catch (Exception e) {
                    System.out.println("Enter the correct CNIC number and must be of length 13 digits ");
                }

            }
            boolean cnicresult = checkcnic(cnic1, path);
            if (cnicresult) {
                cnicpresent = true;
                System.out.println("CNIC found in data ");
            } else {
                System.out.println("Your CNIC number is not found. Please enter a correct one ");
            }
            if (cnicresult) {
                System.out.println();
                System.out.println("You have login to the student menu ");
                System.out.println();
                System.out.println("enter\n1 for editing your data \n2 for leaving hostel \n3 for paying fee");
                System.out.println();
                int student = 0;
                while (true) {
                    try {
                        System.out.print("Enter here..  ");
                        student = input.nextInt();
                        boolean studentinput = numbercheck(student);
                        if (studentinput)
                            break;
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter the integer ");
                        input.nextLine();
                    } catch (Exception ex) {
                        System.out.println("please enter 1 2 or 3");
                        input.nextLine();
                    }
                }
                String studentFilePath1 = "studentdata.text";
                if (student == 1) {
                    editdata(cnic1, studentFilePath1);
                } else if (student == 2) {
                    Admin.deletestudent(cnic1, studentFilePath1);
                    System.out.println("your data has been removed from the file ");
                }
            }
        }
    }
    // We call the Above Fucntion to the Newly created Method when Reserving room;

    public void ReserveRoom() {

        System.out.println("\nThere Are six Double Seater Rooms on the First Floor" +
                "\n The fee on that Floor is 15000 PK Rupees for a Double Seater ROOM" +
                "\n There are six Single Seater Rooms on the Second Floor" +
                "\n The Fee on the Floor is 22000 PK Rupees For a Single Seater ROOM");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("the total rooms are  ");

        Rooms.hostelrooms();
        int floorchoice = 0;
        while (true) {
            try {
                System.out.println("\nPlease Enter YOUr choice:" +
                        "\n1: For a double seater Room on the First Floor" +
                        "\n2: For a single Seater Room on the Second Floor");
                System.out.println("------------------------------------------------------------");
                floorchoice = scanner.nextInt();
                break;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Please Enter again: ");
                scanner.nextLine();
            }
        }

        // From Here
        // STArt From Here Ahmed;

        System.out.println("Enter the room where you want a seat ");
        boolean roomchoice = false;
        int roomchoose = 0;
        while (!roomchoice) {
            try {
                roomchoose = scanner.nextInt();
                if (roomchoose >= 1 && roomchoose <= 6)
                    roomchoice = true;
                else
                    System.out.println("Please enter 1 to 6");
            } catch (Exception e) {
                System.out.println("Please enter the correct input ");
                scanner.nextLine();
            }
        }
        String studentseat = "";
        if (floorchoice == 1) {
            boolean seatchoice = false;
            int seatchoose = 0;
            while (!seatchoice) {
                try {
                    System.out.println("Please enter \n1 for seat no one \n2 for seat no two");
                    seatchoose = scanner.nextInt();
                    if (seatchoose == 1 || seatchoose == 2) {
                        seatchoice = true;
                    } else
                        System.out.println("Please enter 1 or 2");
                } catch (Exception e) {
                    System.out.println("please enter the integer 1 or 2");
                    scanner.nextLine();

                }
            }
            if (roomchoose == 1) {
                if (seatchoose == 1) {
                    studentseat = "F1R1S1";
                } else
                    studentseat = "F1R1S2";
            } else if (roomchoose == 2) {

                if (seatchoose == 1) {
                    studentseat = "F1R2S1";
                } else
                    studentseat = "F1R2S2";
            } else if (roomchoose == 3) {
                if (seatchoose == 1) {
                    studentseat = "F1R3S1";
                } else
                    studentseat = "F1R3S2";
            } else if (roomchoose == 4) {
                if (seatchoose == 1) {
                    studentseat = "F1R4S1";
                } else
                    studentseat = "F1R4S2";
            } else if (roomchoose == 5) {
                if (seatchoose == 1) {
                    studentseat = "F1R5S1";
                } else
                    studentseat = "F1R5S2";
            } else if (roomchoose == 6) {
                if (seatchoose == 1) {
                    studentseat = "F1R6S1";
                } else
                    studentseat = "F1R6S2";
            }

        } else if (floorchoice == 2) {
            if (roomchoose == 1)
                studentseat = "F2R1";
            else if (roomchoose == 2) {
                studentseat = "F2R2";
            } else if (roomchoose == 3) {
                studentseat = "F2R3";
            } else if (roomchoose == 4) {
                studentseat = "F2R4";
            } else if (roomchoose == 5) {
                studentseat = "F2R5";
            } else if (roomchoose == 6) {
                studentseat = "F2R6";
            }

        }
        System.out.println(studentseat);
        boolean roomfound = roomavailable(studentseat, floorchoice);
        System.out.println(roomfound);
    }
    // FOr Chicking if room avilable

    // Module5 For checkng the given room no is available or not
    public static boolean roomavailable(String roomno, int floorchoice) {
        boolean found = false;
        Scanner x;
        String floorno = "";
        String emptycheck = "";
        String empty = "empty";
        String temproom = "";
        if (floorchoice == 1) {
            try {
                x = new Scanner(new File("floor1.text"));
                while (x.hasNext() && !found) {
                    temproom = x.next();
                    floorno = x.next();
                    emptycheck = x.next();
                    if (temproom.trim().equals(roomno.trim()) && emptycheck.trim().equals(empty.trim())) {
                        found = true;
                    }
                }
                x.close();
            } catch (Exception e) {
                return found;
            }
        } else if (floorchoice == 2) {
            try {
                x = new Scanner(new File("floor2.text"));

                while (x.hasNext() && !found) {
                    temproom = x.next();
                    floorno = x.next();
                    emptycheck = x.next();
                    if (temproom.trim().equals(roomno.trim()) && emptycheck.trim().equals(empty.trim())) {
                        found = true;
                    }
                }
                x.close();
            } catch (Exception e) {
                return found;
            }
        }
        return found;
    }

    public void getStudentDetails() {
        ReserveRoom();
    }

    // for adding new student data in the student file

    public void newstudentdata(int floor, String[] data) {
        String room = data[1];
        System.out.println(room);
        Scanner x;
        int size = data.length;
        if (floor == 1) {
            // floorchoice = "FLOOR1";
            String temfile = "tem.txt";
            File oldfile = new File("floor1.text");
            File newfile = new File(temfile);
            String temproom = "";
            String tempfloor = "";
            String empty = "";
            String booked = "booked";
            try {
                FileWriter fw = new FileWriter(temfile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File("floor1.text"));
                while (x.hasNext()) {
                    temproom = x.next();
                    tempfloor = x.next();
                    empty = x.next();
                    if (temproom.equals(room)) {
                        pw.println(temproom + " " + tempfloor + " " + booked);
                    } else {
                        pw.println(temproom + " " + tempfloor + " " + empty);
                    }
                }
                x.close();
                pw.flush();
                pw.close();
                oldfile.delete();
                File dump = new File("floor1.text");
                newfile.renameTo(dump);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (floor == 2) {
            String temfile = "tem.txt";
            File oldfile = new File("floor2.text");
            File newfile = new File(temfile);
            String temproom = "";
            String tempfloor = "";
            String empty = "";
            String booked = "booked";
            try {
                FileWriter fw = new FileWriter(temfile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File("floor2.text"));
                while (x.hasNext()) {
                    temproom = x.next();
                    tempfloor = x.next();
                    empty = x.next();
                    if (temproom.equals(room)) {
                        pw.println(temproom + " " + tempfloor + " " + booked);
                    } else {
                        pw.println(temproom + " " + tempfloor + " " + empty);
                    }
                }
                x.close();
                pw.flush();
                pw.close();
                oldfile.delete();
                File dump = new File("floor2.text");
                newfile.renameTo(dump);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            FileWriter fw = new FileWriter("studentdata.text", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int i = 0; i < size; i++) {
                pw.print(data[i] + " ");
            }
            pw.println();
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println("Your data has not been stored in the student file");
        } catch (Exception e) {
            System.out.println("There is some problem in the student file ");
        }
    }

    // Module For checking cnic number in student file
    public boolean checkcnic(String cnic, String path) {
        Scanner x;
        boolean found = false;
        String tempcnic = "";
        String temproom = "";
        String tempname = "";
        String tempphone = "";
        String tempjob = "";
        String tempfee = "";
        try {
            x = new Scanner(new File(path));
            while (x.hasNext() && !found) {
                tempcnic = x.next();
                temproom = x.next();
                tempname = x.next();
                tempphone = x.next();
                tempjob = x.next();
                tempfee = x.next();
                if (tempcnic.trim().equals(cnic))
                    found = true;
            }
            x.close();

        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return found;
    }

    // for checking input
    public boolean numbercheck(int num) throws Exception {
        boolean found = false;
        if (num > 3)
            throw new Exception("Enter the correct number");
        if (num == 1 || num == 2 || num == 3)
            found = true;
        return found;
    }

    public void editdata(String cnic1, String path) {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println("Enter\n1 to edit CNIC\n2 to edit name\n3 to change phone number");
        System.out.println();
        System.out.println();
        int editdata = 0;
        boolean studentedit = false;
        while (!studentedit) {
            try {
                System.out.print("Enter the number here... ");
                editdata = input.nextInt();
                boolean check2 = numbercheck(editdata);
                if (check2)
                    studentedit = true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter the integer");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Please enter 1 2 or 3");
                input.nextLine();
            }
        }
        switch (editdata) {
            case 1: {
                System.out.println("\n");
                boolean newCnicCheck = false;
                String newcnic = "";
                while (!newCnicCheck) {
                    try {
                        System.out.println("Enter your new CNIC number here ");
                        newcnic = input.next();
                        boolean cnic = idchecker(newcnic);
                        if (cnic)
                            newCnicCheck = true;
                    } catch (Exception e) {
                        System.out.println("Please enter the correct number ");
                    }
                }
                editcnic(cnic1, path, newcnic);
                System.out.println("CNIC updated");
                break;
            }
            case 2: {
                System.out.println("\n");
                String newname = "";
                boolean newnamecondition = false;
                input.nextLine();
                while (!newnamecondition) {
                    System.out.print("Enter your new name here.. ");
                    newname = input.nextLine();
                    if (newname.length() > 2) {
                        boolean newnamecheck = nameOrprofessioncheck(newname);
                        if (newnamecheck)
                            newnamecondition = true;
                        else
                            System.out.println("Please enter the alphabetS only");
                    } else
                        System.out.println("The length of your name should be greater than 2");
                }
                newname = newname.replace(" ", "_");
                editname(cnic1, path, newname);
                System.out.println("Name updated");
                break;
            }
            case 3: {
                System.out.println("\n");
                boolean newphoneCheck = false;
                String newphone = "";
                while (!newphoneCheck) {

                    System.out.println("Enter your new phone number here ");
                    newphone = input.next();
                    boolean phone = phonenumberchecker(newphone);
                    if (phone)
                        newphoneCheck = true;
                    else
                        System.out.println("Enter the correct phone number of length 11 digits");

                }
                editphone(cnic1, path, newphone);
                System.out.println("Phone number updated");
                break;
            }
        }
    }

    // for editing cnic number
    public static void editcnic(String cnic, String path, String newcnic) {
        Scanner x;
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
                    pw.println(newcnic + " " + temproom + " " + tempname + " " + tempphone + " " + tempjob + " "
                            + tempfee);
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
        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // for editing name of student

    public static void editname(String cnic, String path, String newname) {
        Scanner x;
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
                    pw.println(tempcnic + " " + temproom + " " + newname + " " + tempphone + " " + tempjob + " "
                            + tempfee);
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
        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // for editting phone number of student

    public static void editphone(String cnic, String path, String newphone) {
        Scanner x;
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
                    pw.println(tempcnic + " " + temproom + " " + tempname + " " + newphone + " " + tempjob + " "
                            + tempfee);
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
        } catch (IOException e) {
            System.out.println("Something is wrong with file ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
