package com.company;

import java.io.*;
import java.util.Scanner;

class Dice {
    public static void Createfile() throws IOException {
        PrintWriter outstream = new PrintWriter
                (new BufferedWriter
                        (new OutputStreamWriter
                                (new FileOutputStream("Value_At_The_Dices.txt"), "UTF-8")));//Ström som kopplas till filen "Varde_pa_tarningarna"


        int Value_At_Dice = 0;

        ////Here is a loop which count all dices and create values for each dice.
        for (int Dicecounter = 1; Dicecounter <= 1000; Dicecounter++) {
            Value_At_Dice = (int) (Math.random() * 6) + 1;//The value of the dices is beeing randoomed and  I add 1 to the variable Value_At_Dice else can the value zero be randoomed.

            outstream.println(Value_At_Dice);
        }
        //This command do so that all data printed to the file is saved in the file.
        outstream.close();


    }

    public static int[] createArray() throws IOException {
        int[] Array_With_Value_at_dices = new int[1000];
        Scanner filereader = new Scanner(new File("Value_At_The_Dices.txt"));
        int rowcounter = 0;
        //Every line in the file "Value_At_The_Dices" is read by the scanner and the digit on the line is stored in the array.
        while (filereader.hasNext()) {
            Array_With_Value_at_dices[rowcounter] = filereader.nextInt();
            rowcounter++;
        }
        return Array_With_Value_at_dices;

    }

    public static int[] analyseArray(int[] Array_With_Value_At_Dices) {
        int[] Array_To_Analyse_The_Values = new int[6];
        int counter;
        for (counter = 0; counter < Array_With_Value_At_Dices.length; counter++) {// Here is a loop which goes through the array therethe values are and stores them in the array which shall analyse the values.  .
            //This code checks which value each component in the array "Array_With_Value_At_Dices" has and increases the correspond component's value with 1. .
            if (Array_With_Value_At_Dices[counter] == 1)
                Array_To_Analyse_The_Values[0]++;
            else if (Array_With_Value_At_Dices[counter] == 2)
                Array_To_Analyse_The_Values[1]++;
            else if (Array_With_Value_At_Dices[counter] == 3)
                Array_To_Analyse_The_Values[2]++;
            else if (Array_With_Value_At_Dices[counter] == 4)
                Array_To_Analyse_The_Values[3]++;
            else if (Array_With_Value_At_Dices[counter] == 5)
                Array_To_Analyse_The_Values[4]++;
            else
                Array_To_Analyse_The_Values[5]++;
        }
        System.out.println("Antal ettor ar " + Array_To_Analyse_The_Values[0] + "." + '\n' + "Antalet tvaor ar " + Array_To_Analyse_The_Values[1] + "." + '\n' + "Antalet treor ar " + Array_To_Analyse_The_Values[2] + "." + '\n' + "Antalet fyror ar " + Array_To_Analyse_The_Values[3] + "." + '\n' + "Antalet femmor ar " + Array_To_Analyse_The_Values[4] + "." + '\n' + "Antalet sexor ar " + Array_To_Analyse_The_Values[5] + ".");
        return Array_To_Analyse_The_Values;


    }


}


public class Table_With_Values_Of_Hitten_Dices {
    public static void main(String[] args) throws IOException {
        Dice.Createfile();

        int[] First_Call = Dice.createArray();
        int[] Second_call = Dice.analyseArray(First_Call);


    }
}




