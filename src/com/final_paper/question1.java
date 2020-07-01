package com.final_paper;
import java.io.*;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

class LineItem{
    public String Product;
    public int Quantity;
    public float unit_price;
    public float total;



}

class invoices extends LineItem{
    Date currentDate = new Date();



    public String UniqueID;
    public String CustomerName;




}

class Receipt extends invoices {
    public String DateOfOrder;
    public String DateOfDelivery;
    public float weightOfParcel;

    public void getDetail() throws IOException {
        File_insertion();
        Scanner obj =new Scanner(System.in);
        System.out.print("The name of customer is: ");
        CustomerName = obj.nextLine();

        do{
            System.out.print("Product name: ");
            Product = obj.nextLine();
            System.out.print("Weight in kilogram: ");
            weightOfParcel= obj.nextFloat();
            System.out.print("Price: ");
            unit_price= obj.nextFloat();
            System.out.print("Quantity: ");
            Quantity = obj.nextInt();
            System.out.print("If you want to confirm order press 0 want to change press 1: ");
            float bill=Quantity*unit_price;
            total =+ bill;

            if (obj.nextInt()==0){
                displayDetail();
                calculateGrandTotal();
                System.exit(1);
            }

            obj.nextLine();
        }while(true);

    }
    public void calculateGrandTotal() throws IOException {
        System.out.print("The total bill is: "+total);

        System.out.println("View File 1) for view");

        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();

        if(a == 1){
            Display_file_resipt();
        }
    }

    public void displayDetail() throws IOException {

        Random ran = new Random();
        int ran_int=ran.nextInt(10)+89;
        UniqueID = String.valueOf(ran_int);

        System.out.print("\nReceipt\t\t\t\t");
        System.out.println(currentDate);
        System.out.print("ID: ");
        System.out.println(UniqueID+"" + Product.charAt(Product.length() - 1));
        System.out.println("Customer Name: "+CustomerName);
        System.out.println("Product: "+Product);
        System.out.println("Weight: "+weightOfParcel+" kg");
        System.out.println("Price: "+unit_price);
        System.out.println("Quantity: "+Quantity);

        Date DateofOrder = new Date();

        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateOfOrder = formatter.format(DateofOrder);

        System.out.println("Ordered Date: "+DateOfOrder);

        Date DayofDelievry = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(DayofDelievry);
        cal.add(Calendar.DATE, 3);
        Date modifiedDate = cal.getTime();

        Format format = new SimpleDateFormat("dd/MM/yyyy");
        DateOfDelivery = format.format(modifiedDate);

        System.out.println("Delivery Date: "+DateOfDelivery);

        Insert_into_resipt();


    }

    public void File_insertion() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt2.txt";


        Rescipts object_for_file_reseipt = new Rescipts();

        try {
            File file_receipt = new File(filename_receipt);


            if(file_receipt.createNewFile()){
                System.out.println("File Created");
            }


        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void Insert_into_resipt() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt2.txt";
        BufferedWriter writer_receipt = new BufferedWriter(new FileWriter(filename_receipt,true));
        PrintWriter pw = new PrintWriter(writer_receipt);

        writer_receipt.write("\n"+currentDate+"    "+UniqueID+"" + Product.charAt(Product.length() - 1)+"          "+CustomerName+" "+Product+" "+weightOfParcel+"  "+unit_price+""+Quantity+" "+DateOfOrder+DateOfDelivery+"\n");
        writer_receipt.close();
        System.out.println("FileWriter succesfully");
    }

    public void Display_file_resipt() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt2.txt";
        BufferedReader dsc = new BufferedReader(new FileReader(filename_receipt));
        String read;
        while ((read = dsc.readLine()) != null){
            System.out.println(read);
        }
        //check.recorddelte(filename,"sdf",1,"\n");
        dsc.close();
    }

}

public class question1{

    public static void main(String[] args) throws IOException {
        Receipt r= new Receipt();
        r.getDetail();
        r.calculateGrandTotal();


    }
}