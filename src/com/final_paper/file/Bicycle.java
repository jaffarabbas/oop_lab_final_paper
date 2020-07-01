package com.final_paper.file;

class TwoWheeler {
    String vehicleId;
    String type;
    int wheels;
    float price;
    public TwoWheeler(String vId, String vType, int tyres, float rate) {
        vehicleId=vId;
        type=vType;
        wheels=tyres;
        price=rate;
    }
    public void printDetails(){
        System.out.println("Bicycle Id: "+vehicleId);
        System.out.println("Bicycle Type: " +type);
        System.out.println("Wheels: "+wheels);
        System.out.println("Price: "+price+"$");
    }
} public class Bicycle extends TwoWheeler{
    boolean gear;
    public Bicycle(String vId, String vName, int tyres, float price, boolean gear) {
        super(vId,vName ,tyres,price);
        this.gear=gear;
    }
    public void printDetails() {
        super.printDetails();//super is used in here to use super class method again
        if (gear == true) {
            System.out.println("Geared:Yes");
        } else {
            System.out.println("Geared:No");
        }
    }
    public static void main(String[] args) {
        TwoWheeler obj = new Bicycle("B001" + "","Mountain-Bicycle",2,200,true);
        obj.printDetails();
    }
}
