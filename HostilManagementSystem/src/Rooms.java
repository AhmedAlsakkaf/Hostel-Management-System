import java.io.File;
import java.util.Scanner;

public class Rooms{
    private int roomNumber;
    private int roomType;

    public void setRoomNumber(int number) {
        roomNumber = number;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomType(int type) {
        roomType = type;
    }

    public int getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
    }

    public void roomDetail() {
        display();
    }
     // Module18 For printing hostel rooms of both floors for the manager
    public static void hostelrooms() {
        Scanner x;
        String room = "";
        String floor = "";
        String empty = "";
        try {
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("The  rooms on floor 1 is ");
            System.out.println("-------------------------");
            System.out.println();
            x = new Scanner(new File("floor1.text"));
            while (x.hasNext()) {
                room = x.next();
                floor = x.next();
                empty = x.next();
                System.out.print(room + " " + floor + " " + empty + " \n");
            }
            x.close();
        } catch (Exception e) {
            System.out.println("Something is wrong with the files ");
        }
        try {
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("The rooms on floor 2 is ");
            System.out.println("-------------------------");
            System.out.println();
            x = new Scanner(new File("floor2.text"));
            while (x.hasNext()) {
                room = x.next();
                floor = x.next();
                empty = x.next();
                System.out.println(room + " " + floor + " " + empty);
            }
            x.close();
        } catch (Exception e) {
            System.out.println("Some problem occured ");
        }
    }
}
