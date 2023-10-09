import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Person {
    private String name;
    private int age;
    private String phoneNumber;
    private String id;
    public Person(){
        name = null;
        age = 0;
        phoneNumber = null;
        id = null;
    }
    public Person(String name, int age, String phoneNumber, String id) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public static boolean signup(String username, String password, String filepath){
        Scanner x;
        try{
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(username+" "+password);
            pw.flush();
            pw.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean signin(String username,String password, String filepath){
        Scanner x;
        String tempuername = "";
        String temppassword = "";
        boolean found = false;
        try {
            x = new Scanner(new File(filepath));
            while (x.hasNext()&&!found) {
                tempuername = x.next();
                temppassword = x.next();
                if (tempuername.trim().equals(username.trim()) && temppassword.trim().equals(password.trim()))
                    found =  true;

            }
            x.close();
        }catch (Exception e){
            System.out.println("Error in login file");
        }
        return found;
    }
    // for checking id validation 

    public  boolean idchecker(String cnic )throws Exception{
        if (cnic.length()!=13){
            throw new Exception("Enter CNIC number of length 13 digits ");
        }
        boolean card = false;
        int count = 0;
        if (cnic.length()==13){
            for (int i=0;i<cnic.length();i++){
                if (cnic.charAt(i)>='0' && cnic.charAt(i)<='9'){
                    count++;
                }
            }
            if (count==13){
                card=true;
            }
        }else
            return card;
        return card;
    }

    // for checking phone no 

    public boolean phonenumberchecker(String phone){
        boolean number = false;
        int count = 0;
        if (phone.length()==11){
           for (int i = 0; i<phone.length();i++){
               if (phone.charAt(i)>='0'&& phone.charAt(i)<='9'){
                   count++;
               }
           }

           if (count==11) {
               number = true;
           }
        }else
            return number;
        return number;
    }
// for checking name or profession 
    public boolean nameOrprofessioncheck(String word){
        return Pattern.matches("[a-zA-Z\s]+",word);
    }
}
