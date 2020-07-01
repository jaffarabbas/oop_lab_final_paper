package com.final_paper.file;


public class Tester{
    public static void main(String[] args)throws Exception
    { int sum = 0; final int grace = 20;
        try {
            for(int i = 3; i<5; i++)
            {
                sum = sum + Integer.parseInt(args[i]); //Integer.parseInt() converts string into integer
            }
            int perGrace=grace*100/sum; System.out.println("Sum is:"+sum);
            System.out.println("Percentage grace is:"+perGrace);
        }

        catch(ArithmeticException ex)
        {
            System.out.println("Division by zero");
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Unreachable array index"); }
        catch(Exception ex)//it was on top know i use it in bottom
        {
            System.out.println("Error in code");
        }
    }
}