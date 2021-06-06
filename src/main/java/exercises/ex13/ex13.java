package exercises.ex13;

import java.util.Scanner;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Erik Dokken
 */
public class ex13 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ex13 example13 = new ex13();

        String principalNum = example13.principalInput();
        String interestNum = example13.interestInput();
        String yearsNum = example13.yearsInput();
        String compoundNum = example13.compoundInput();

        //Conversion
        int principal = example13.intPrinc(principalNum);
        double interest = example13.doubInter(interestNum);
        int years = example13.intYear(yearsNum);
        int compound = example13.intCompound(compoundNum);

        double worth = example13.worthCal(principal, interest, years, compound );
        double worthRounded = example13.rounding(worth);
        //Output
        String outputString = example13.outputString(principalNum, interestNum, yearsNum, compoundNum, worthRounded);

        example13.printOutput(outputString);
    }

    private double rounding(double worth) {
        if(worth % 1 == 0)
        {
            int roundOff = (int) worth;
            return roundOff;
        }
        double roundOff = Math.round(worth * 100.0) / 100.0;
        return roundOff;
    }

    private double worthCal(int principal, double interest, int years, int compound) {
        double inter = interest/100;
        double worthCalc = principal * Math.pow(1 + (inter / compound), compound * years);
        return worthCalc;
    }

    private void printOutput(String outputString) {System.out.println(outputString);
    }

    private String outputString(String principalNum, String interestNum, String yearsNum, String compoundNum, double worth) {
        return "$" + principalNum + " invested at " + interestNum + "% for " + yearsNum + " years compounded " + compoundNum + " times per year is $" + worth +".";
    }

    private int intCompound(String compoundNum) {
        int intCompound = Integer.parseInt(compoundNum);
        return intCompound;
    }

    private int intYear(String yearsNum) {
        int intYear = Integer.parseInt(yearsNum);
        return intYear;
    }
    private double doubInter(String interestNum) {
        double doubInter = Double.parseDouble(interestNum);
        return doubInter;
    }

    private int intPrinc(String principalNum) {
        int IntPrinc = Integer.parseInt(principalNum);
        return IntPrinc;
    }

    private String compoundInput() {
        System.out.print("What is the number of times the interest is compounded per year? ");
        String compound = in.nextLine();
        return compound;
    }

    private String yearsInput() {
        System.out.print("What is the number of years? ");
        String interYears = in.nextLine();
        return interYears;
    }

    private String interestInput() {
        System.out.print("What is the rate? ");
        String interInput = in.nextLine();
        return interInput;
    }

    private String principalInput() {
        System.out.print("What is the principal amount? ");
        String princInput = in.nextLine();
        return princInput;
    }
}
