package util;

import java.util.*;
import java.io.*;

public class ReadInput {

    public static String[] GetInputStr(int dayNum) throws IOException{

        String fPath = GetFilePath(dayNum);
        File file = new File(fPath);
        String fileIn[] = new String[GetFileLen(fPath)]; //Declare array to length of file lines
        // for (int s = 0; s < fileIn.length; s++) fileIn[s] = ""; // Initialize with ""

        Scanner sf = new Scanner(file); //Open file
        int maxIndx = -1;
        while(sf.hasNext()){    //Read in lines from file
            maxIndx++;
            fileIn[maxIndx] = sf.nextLine();
        }
        sf.close();             //Close file

        return fileIn;          //Pass back new array
    }

    public static int[] GetInputInt(int dayNum) throws IOException{

        String fPath = GetFilePath(dayNum);
        File file = new File(fPath);
        int fileIn[] = new int[GetFileLen(fPath)]; //Declare array to length of file lines

        Scanner sf = new Scanner(file); //Open file
        int maxIndx = -1;
        while(sf.hasNext()){    //Read in lines from file
            maxIndx++;
            fileIn[maxIndx] = Integer.parseInt(sf.nextLine());
        }
        sf.close();             //Close file

        return fileIn;          //Pass back new array
    }

    public static long[] GetInputLong(int dayNum) throws IOException{

        String fPath = GetFilePath(dayNum);
        File file = new File(fPath);
        long fileIn[] = new long[GetFileLen(fPath)]; //Declare array to length of file lines

        Scanner sf = new Scanner(file); //Open file
        int maxIndx = -1;
        while(sf.hasNext()){    //Read in lines from file
            maxIndx++;
            fileIn[maxIndx] = Long.parseLong(sf.nextLine());
        }
        sf.close();             //Close file

        return fileIn;          //Pass back new array
    }

    private static String GetFilePath(int dayNum){
        String fDir = "C:\\Users\\Hofmjc\\Documents\\Proj_MyDoc\\AoC2020\\javaSrc\\textIn";
        String fName = "Day" + dayNum + "Input.txt";
        String fPath = fDir + "\\" + fName;
        return fPath;
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