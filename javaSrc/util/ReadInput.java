package util;

import java.util.*;
import java.io.*;

public class ReadInput {

    public static String[] GetInput(int dayNum) throws IOException{

        String fDir = "C:\\Users\\Hofmjc\\Documents\\Proj_MyDoc\\AoC2020\\javaSrc\\textIn";
        String fName = "Day" + dayNum + "Input.txt";
        String fPath = fDir + "\\" + fName;
        File file = new File(fPath);

        String fileIn[] = new String[GetFileLen(fPath)]; //Declare array to length of file lines
        for (int s = 0; s < fileIn.length; s++) fileIn[s] = ""; // Initialize with ""

        Scanner sf = new Scanner(file); //Open file

        int maxIndx = -1;
        while(sf.hasNext()){    //Read in lines from file
            maxIndx++;
            fileIn[maxIndx] = sf.nextLine();
        }
        sf.close();             //Close file

        return fileIn;          //Pass back new array


        // for(int j=0;j<=maxIndx;j++) System.out.println(text[j]);

        // Day8.update(text);  //<===== Change to match day

    }

    private static int GetFileLen(String fPaNa)  throws IOException{
        String txt;
        File file = new File(fPaNa);
        Scanner sf = new Scanner(file);
        int i = 0;
        while(sf.hasNext()){
            txt = sf.nextLine();
            i++;
        }
        sf.close();
        return i;
    }

}