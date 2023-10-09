import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hostelite extends Person {
    private String address;
    private int roomno;
    public Hostelite() {
        super();
        this.address = null;
        this.roomno = 0;
    }
    public Hostelite(String name, int age, String phoneNumber, String id, String address, int roomno) {
        super(name, age, phoneNumber, id);
        this.address = address;
        this.roomno = roomno;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getRoomno() {
        return roomno;
    }
    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }
    // for printing the rooms available in the hostel 
    public static boolean floors(int choice){
        Scanner x;
        String room = "";
        String floor = "";
        String empty = "";
        if (choice==1){
            try {
                System.out.println("The available rooms on floor 1 are ");
                x = new Scanner(new File("floor1.text"));
                while (x.hasNext()){
                    room = x.next();
                   floor=x.next();
                   empty = x.next();
                   System.out.print(room+" "+floor+" "+empty+" \n");
                }x.close();
                return true;
            }catch (Exception e){
                return false;
            }
        } else if (choice==2) {
            try {
                System.out.println("The availabe rooms on floor 2 are ");
                x = new Scanner(new File("floor2.text"));
                while (x.hasNext()){
                    room = x.next();
                    floor=x.next();
                    empty = x.next();
                    System.out.println(room+" "+floor+" "+empty);
                }x.close();
                return true;
            }catch (Exception e){
                return false;
            }
        }else
            return false;
    }

    // for checking the roomno available or not 
    public static boolean roomavailable(String roomno, int floorchoice ){
        boolean found = false;
        Scanner x;
        String floorno = "";
        String emptycheck = "";
        String empty = "empty";
        String temproom = "";
        if (floorchoice==1){
            try {
                x = new Scanner(new File("floor1.text"));
                while (x.hasNext()&&!found){
                    temproom = x.next();
                    floorno= x.next();
                    emptycheck = x.next();
                    if (temproom.trim().equals(roomno.trim()) && emptycheck.trim().equals(empty.trim())){
                        found = true;
                    }
                }x.close();
            }catch (Exception e){
                return found;
            }
        } else if (floorchoice==2) {
            try {
                x = new Scanner(new File("floor2.text"));

                while (x.hasNext()&&!found){
                    temproom = x.next();
                    floorno= x.next();
                    emptycheck = x.next();
                    if (temproom.trim().equals(roomno.trim()) && emptycheck.trim().equals(empty.trim())){
                        found = true;
                    }
                }x.close();
            }catch (Exception e){
                return found;
            }
        }
        return found;
    }

    // for editing cnic data 

    public static  void editcnic(String cnic, String path, String newcnic){
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
            FileWriter fw = new FileWriter(newfile , true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(path));
            while (x.hasNext()){
                tempcnic = x.next();
                temproom = x.next();
                tempname = x.next();
                tempphone = x.next();
                tempjob = x.next();
                tempfee = x.next();
                if (tempcnic.trim().equals(cnic.trim())){
                    pw.println(newcnic+" "+temproom+" "+tempname+" "+tempphone+" "+tempjob+" "+tempfee);
                }else {
                    pw.println(tempcnic+" "+temproom+" "+tempname+" "+tempphone+" "+tempjob+" "+tempfee);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            filepath.delete();
            File dump = new File(path);
            newfile.renameTo(dump);
        }catch (IOException e){
            System.out.println("Something is wrong with file ");
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
