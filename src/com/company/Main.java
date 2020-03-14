package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static int [] ArabicSimbols =
            {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String [] RomanSimbols =
            {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                    "IX", "V", "IV", "I"};

    public static String arabicToRoman(int num) {
        String numeric="";
        int BitDepth;
        int index=0;
        while (index<ArabicSimbols.length)
        {
            BitDepth = (int)num/ArabicSimbols[index];
            for (int i = 0; i < BitDepth; i++)
            {
                numeric += RomanSimbols[index];
            }
            num -= BitDepth*ArabicSimbols[index];
            index++;
        }
        return numeric;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            System.out.println("Enter the number: ");
            int number;
            try {
                 number = Integer.parseInt(reader.readLine());
                if (number == 0 || number >= 5000 ) {
                    System.err.println("ERROR");

                } else {
                    String romanNumber = arabicToRoman(number);
                    System.out.println("After convertation " + romanNumber);
                    flag  = false;
                }
            } catch (NumberFormatException e ) {
                System.err.println("You  enter a string");
            }
        }
    }
}
