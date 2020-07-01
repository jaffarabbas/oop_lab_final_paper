package com.final_paper;

//Question 1


//total classes

/*

class digramm
                      invoice:---------->\
processDocument---------->                ------->Lineitems:---->Product
                      rescipt:---------->/
*/

//oop concepts encapsulation and inheritance and polymorphism

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//class 1
class Rescipts extends LineItems{

    private int UniqueId;
    private String DateofOrder;
    private String DateofDelivery;
    private String CustumerName;
    private double weight_of_parcel;
    int check_for_product;
    Scanner scanner_for_instance_varibale_of_Recipts = new Scanner(System.in);


    //getersetter for unique id
    public int getUniqueId() {
        return UniqueId;
    }

    public void setUniqueId(int uniqueId) {
        UniqueId = uniqueId;
    }
    //getersetter for  Date of order
    public String getDateofOrder() {
        return DateofOrder;
    }

    public void setDateofOrder(String dateofOrder) {
        DateofOrder = dateofOrder;
    }
    //getersetter for  date of delivery

    public String getDateofDelivery() {
        return DateofDelivery;
    }

    public void setDateofDelivery(String dateofDelivery) {
        DateofDelivery = dateofDelivery;
    }
    //getersetter for  customer name
    public String getCustumerName() {
        return CustumerName;
    }

    public void setCustumerName(String custumerName) {
        CustumerName = custumerName;
    }

    public double getWeight_of_parcel() {
        return weight_of_parcel;
    }

    public void setWeight_of_parcel(double weight_of_parcel) {
        this.weight_of_parcel = weight_of_parcel;
    }

    //Unique id gentrater
    public int UniqueIdGenerater(){
        Random rand_for_generater = new Random();
        int generater_key = (rand_for_generater.nextInt()%10000)+1000000000;
        return  generater_key;
    }
    //Date_of_order method
    public String Date_inserter(){
        System.out.println("Date of today : : ");
          String date = scanner_for_instance_varibale_of_Recipts.next();
          return date;
    }
    //Date_of_delivery method
    public String Date_of_deleviery_inserter(){
        System.out.println("Date of delivery : ");
        String date = scanner_for_instance_varibale_of_Recipts.next();
        return date;
    }
    //Customer Name method
    public String Customer_name_insert(){
        System.out.println("Customer Name : ");
        String name = scanner_for_instance_varibale_of_Recipts.next();
        return name;
    }
//method
    public double Weight_insertion(){
        System.out.println("Weight of Parcel : ");
        double weight = scanner_for_instance_varibale_of_Recipts.nextDouble();
        return weight;
    }
    //dispatch
    public void Dispatch(){
          boolean flag;
          if(getUniqueId()!=0 || getDateofOrder()!=null || getDateofDelivery()!=null|| getCustumerName()!=null){
              flag = true;
          }else{
              flag =false;
          }

          if(flag){
              System.out.println("*******Dispatched*******");
          }
          else{
              System.out.println("Not dispatched");
          }
    }

    public void LineItems(){
        LineItems object_for_line_itms = new LineItems();
    }
    public void CalculateGrandTotal(){
        caluculate_total();
    }

//show method
     public String toString(){
         System.out.println("********Resipt********");
        return "\nUnique Id: "+getUniqueId()+"\nDate Of Order : "+getDateofOrder()+"\nDate of Delivery : "+getDateofDelivery()+"\nCustomer Name : "+getCustumerName()+"Weight of Parsell : "+getWeight_of_parcel();
//         "\n\n*****Line Items*****\n\nProduct of Line items : \nId :"+id_making()+"\nName : "+getname()+"\nPrice : "+getPrice();
    }


    public void Select_method() throws IOException {

        processDocumnets obj_for_file = new processDocumnets();
        setUniqueId(UniqueIdGenerater());
        setDateofOrder(Date_inserter());
        setDateofDelivery(Date_of_deleviery_inserter());
        setCustumerName(Customer_name_insert());
        setWeight_of_parcel(Weight_insertion());
        //products
        System.out.println("Total Product :");
        check_for_product = scanner_for_instance_varibale_of_Products.nextInt();
        setname(Name_insertion());
        setPrice(price_Insertion());
        Insert_into_file();
        System.out.println("Line Items Selection :\nL)Show receipt\nD)Display Line Items Selecter\nS)Product Show\nV)View from File");

        char selecter = scanner_for_instance_varibale_of_Recipts.next().charAt(0);

        switch (selecter){
            case 'L':
                System.out.println(toString());
                Dispatch();
                obj_for_file.File_insertion();
                break;
            case 'D':
                Display1();
                break;
            case 'S':
                Display2();
                break;
            case 'V':
                Display_file();
                break;
            default:
                Select_method();
                break;
        }

    }

    //isert into file
    public void Insert_into_file() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt.txt";
        BufferedWriter writer_receipt = new BufferedWriter(new FileWriter(filename_receipt,true));
        PrintWriter pw = new PrintWriter(writer_receipt);

        writer_receipt.write("\n"+getUniqueId()+"    "+getDateofOrder()+"          "+getDateofDelivery()+"             "+getCustumerName()+"         "+getWeight_of_parcel()+"\n"+"Products : "+"\nName : "+getname()+"\nPrice : "+getPrice()+"\n");
        writer_receipt.close();
        System.out.println("FileWriter succesfully");
    }

    public void Display_file() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt.txt";
        BufferedReader dsc = new BufferedReader(new FileReader(filename_receipt));
        String read;
        while ((read = dsc.readLine()) != null){
            System.out.println(read);
        }
        //check.recorddelte(filename,"sdf",1,"\n");
        dsc.close();
    }
//    public Rescipts(){
//        Select_method();
//    }
}
//class 2
//invoice class
class Invoice extends LineItems{
    private int UniqueId_invoice;
    private String Date;
    private String CustomerName_invoice;
    int check_for_product;
    Scanner scanner_for_instance_varibale_of_Invoice = new Scanner(System.in);

    public void setUniqueId(int uniqueId) {
        UniqueId_invoice = uniqueId;
    }

    public int getUniqueId() {
        return UniqueId_invoice;
    }

    public void setDate(String date) {
        Date = date;
    }
    public String getDate() {
        return Date;
    }

    public void setCustomerName(String customerName){
        this.CustomerName_invoice = customerName;
    }
    public String getCustomerName(){
        return CustomerName_invoice;
    }

    public String Date_insertion(){
        System.out.println("Date for invoice : ");
        String date = scanner_for_instance_varibale_of_Invoice.next();
        return date;
    }

    public String Nmae_insertion(){
        System.out.println("Name for Invoice : ");
        String name = scanner_for_instance_varibale_of_Invoice.next();
        return name;
    }

    //unique id creater
    public int UniqueIdGenerater(){
        Random rand_for_generater = new Random();
        int generater_key = (rand_for_generater.nextInt()%10000)+1000000000;
        return  generater_key;
    }

    public String toString(){
        System.out.println("********Invoice********");
        return "Unique Id: "+getUniqueId()+"\nDate for Invoice : "+getDate()+"\nCustomer Name : "+getCustomerName();
//         "\n\n*****Line Items*****\n\nProduct of Line items : \nId :"+id_making()+"\nName : "+getname()+"\nPrice : "+getPrice();
    }


    public void Select_method() throws IOException {

        setUniqueId(UniqueIdGenerater());
        setDate(Date_insertion());
        setCustomerName(Nmae_insertion());
        //products
        System.out.println("Total Product :");
        check_for_product = scanner_for_instance_varibale_of_Products.nextInt();
        setname(Name_insertion());
        setPrice(price_Insertion());
        Insert_into_file();//important insert to file
        System.out.println("Line Items Selection :\nL)Show receipt\nD)Display Line Items Selecter\nS)Product Show\nV)View In File\nC)Clear Invoice");

        char selecter = scanner_for_instance_varibale_of_Invoice.next().charAt(0);

        switch (selecter){
            case 'L':
                System.out.println(toString());
                break;
            case 'D':
                Display1();
                break;
            case 'S':
                Display2();
                break;
            case 'V':
                Display_file_invoice();
                break;
            case 'C':
                clear();
                break;
            default:
                Select_method();
                break;
        }

    }

    //Dislay files
    public void Display_file() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt.txt";
        BufferedReader dsc = new BufferedReader(new FileReader(filename_receipt));
        String read;
        while ((read = dsc.readLine()) != null){
            System.out.println(read);
        }
        //check.recorddelte(filename,"sdf",1,"\n");
        dsc.close();
    }

    //insert into file
    public void Insert_into_file() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\invoice.txt";
        BufferedWriter writer_receipt = new BufferedWriter(new FileWriter(filename_receipt,true));
        PrintWriter pw = new PrintWriter(writer_receipt);

        writer_receipt.write("\n"+getUniqueId()+"    "+getDate()+"          "+getCustomerName()+"\n\nProducts : "+"\nName : "+getname()+"\nPrice : "+getPrice()+"\n");
        writer_receipt.close();
        System.out.println("FileWriter succesfully");
    }

    //display files in invoice
    public void Display_file_invoice() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\invoice.txt";
        BufferedReader dsc = new BufferedReader(new FileReader(filename_receipt));
        String read;
        while ((read = dsc.readLine()) != null){
            System.out.println(read);
        }
        //check.recorddelte(filename,"sdf",1,"\n");
        dsc.close();
    }
//clear method for invoice
    public void clear() throws IOException {
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\invoice.txt";
        BufferedWriter writer_receipt = new BufferedWriter(new FileWriter(filename_receipt));
        PrintWriter pw = new PrintWriter(writer_receipt);

        writer_receipt.write(" ");
        writer_receipt.close();
        System.out.println("FIle is clear");
    }
//    public Invoice(){
//        Select_method();
//    }
}

//class 3
//line items
class LineItems extends Productes{

    Scanner scanner_for_instance_varibale_of_LineItems = new Scanner(System.in);
    ArrayList<Productes> collection_of_Product_inctance = new ArrayList<Productes>(5);
    public int quantity;
    public double total;
    public int update;
    public void product_of_Lineitems() throws IOException {

        Rescipts object = new Rescipts();

              for(int i =1;i<=object.check_for_product;i++){
                  Display2();
              }

    }

    int temp;
    public int setQuantity(){
        System.out.println("Enter Quantity : ");
        quantity = scanner_for_instance_varibale_of_LineItems.nextInt();
        return quantity;
    }

    public void UpdateQuantity(){
        int old = setQuantity();
        System.out.println("You want to add or subtract quantity: ");
        char selecter = scanner_for_instance_varibale_of_LineItems.next().charAt(0);

        if(selecter == '+'){
            System.out.println("add new quantity");
            update = old+quantity;
        }
        else if(selecter == '-'){
            System.out.println("subtract new quantity");
            update = old-quantity;
        }
        else{
            UpdateQuantity();
        }
    }

    public void change_product() throws IOException {
        Display2();
    }

    public void caluculate_total(){
        setQuantity();
        System.out.println("total : ");
        total = (quantity*getPrice());
        System.out.println("Total Price : "+total);
    }

    public void Display1() throws IOException {
        System.out.println("1)Show product : \n2)Calulate Total\n3)change Product\n4)Update Quantity");
        int selecter = scanner_for_instance_varibale_of_LineItems.nextInt();
        switch (selecter){
            case 1:
                product_of_Lineitems();
                break;
            case 2:
                caluculate_total();
                break;
            case 3:
                change_product();
                break;
            case 4:
                UpdateQuantity();
                break;
            default:
                Display1();
                break;
        }
    }

}
//class 4
class Productes{

    Scanner scanner_for_instance_varibale_of_Products = new Scanner(System.in);
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //important
    public String id_making(){
         setId(name);
         String first_2_letter = getId();
         String last_2_letter = getId();

         String Generate = first_2_letter.substring(0,2) + last_2_letter.substring(last_2_letter.length()-2);
         return Generate;
    }


    public String Name_insertion(){
        System.out.println("Product Name : ");
        String name = scanner_for_instance_varibale_of_Products.next();
        return name;
    }
    public double price_Insertion(){
        System.out.println("Product Price : ");
        double price = scanner_for_instance_varibale_of_Products.nextDouble();
        if(price <= 0){
            price_Insertion();
        }
        return price;
    }
    //Rescipts obj_of_fler = new Rescipts();
//dipplay product
    public void Display2() throws IOException {
        System.out.println("Id : "+id_making());
        setname(Name_insertion());
        setPrice(price_Insertion());
        System.out.println("Name : "+getname()+"\nPrice : "+getPrice());


    }

    //constructer to make default




}
//class 5
//selecting class
class processDocumnets{
    Scanner scanner_for_instance_varibale_of_processDocuments = new Scanner(System.in);
    void select_class() throws IOException {
        System.out.println("Select your mode : \n1)Rescipt\n2)Invoice");
        int selecter = scanner_for_instance_varibale_of_processDocuments.nextInt();
        switch (selecter){
            case 1:
                Rescipts obj = new Rescipts();
                obj.Select_method();
                break;
            case 2:
                Invoice obj2 = new Invoice();
                obj2.Select_method();
                break;
            default:
                select_class();
                break;
        }
    }

//filing creating 2 file resipts aand invoice

    public void File_insertion(){
        String filename_receipt = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\receipt.txt";
        String filename_invoice = "C:\\Users\\gamap\\OneDrive\\Documents\\GitHub\\oop_lab_final_paper\\src\\com\\final_paper\\file\\invoice.txt";

        Rescipts object_for_file_reseipt = new Rescipts();

        try {
            File file_receipt = new File(filename_receipt);
            File file_invoice = new File(filename_invoice);

            if(file_receipt.createNewFile()){
                System.out.println("File Created");
            }

            if(file_invoice.createNewFile()){
                System.out.println("File Created");
            }
//

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

public class Question_1 {

    public static void main(String[] args) throws IOException {
    processDocumnets obj = new processDocumnets();
    obj.select_class();
    }
}
