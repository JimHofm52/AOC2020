//Advant of Code 2020
/*
Programmer: Jim Hofmann
Date Created: 12/5/2020
*/

import java.util.*;
import java.io.*;
//import days.AllDays;   //<===== Change to match day
import days.Day8;   //<===== Change to match day

public class AoC2020 {
    public static void main(String[] arg) throws IOException{

        int day = 8;    //<===== Change to match day
        String fPath = "C:\\Users\\Hofmjc\\Documents\\Proj_MyDoc\\AoC2020\\javaSrc\\textIn";
        String fName = "Day" + day + "Input.txt";
        File file = new File(fPath + "\\" + fName);
        Scanner sf = new Scanner(file);
        
        int maxIndx = -1;   //-1 so we increment below, first index is 0
        String text[] = new String[650];    //to be safe, declare more than we need

        for( int s = 0; s < text.length; s++) text[s] = "";

        while(sf.hasNext()){
            maxIndx++;
            text[maxIndx]=sf.nextLine();
        }
        sf.close();

        // for(int j=0;j<=maxIndx;j++) System.out.println(text[j]);

        Day8.update(text);  //<===== Change to match day
    }
}