package days;

import java.io.IOException;

import util.*;

public class Day16{

    public static void update() throws IOException {
        int fileNum = 16;                   //File number of input
        int dataIn[] = ReadInput.GetInputIntCS(fileNum);// Get input in an array
        int len = dataIn.length;

        // ---- Part 1 ------
        int ans = FindSaidLst2(dataIn, 2020);
        System.out.println("\nPart 1 - " + ans);    // Confirmed - Part 1 - (161 - ??)

        // ----- Part 2 ------
        ans = FindSaidLst2(dataIn, 30000000);
        System.out.println("\nPart 2 - " + ans);// Confirmed - Part 2 - ??(161 - ??)
    }

    // ----------------------------------- Parce Input ----------------------------------
    // None needed

    // ----------------------------------- Part 1 & 2 ----------------------------------

}