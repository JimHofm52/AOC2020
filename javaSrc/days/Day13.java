package days;

import java.io.IOException;

import util.*;

public class Day13 {

    public static void update() throws IOException {
        int fileNum = 13;       //File number of input
        String readIn[] = ReadInput.GetInputStr(fileNum);// Get input in an array for 13(131)
        int dTime = Integer.parseInt(readIn[0]);
        int schd[] = ParceIn(readIn[1]);    //Schdules
        int len = schd.length;              // Length of input schd
        int a = 0;
        // ---- Part 1 ------
        int ans[] = new int[2];
        FindClosest(dTime, schd, ans);
        a = schd[ans[0]] * ans[1];
        System.out.println("\nPart 1 - " + a); // Confirmed - Part 1 Manhattan adr - 2095(295)

        // ----- Part 2 ------
        /**
         * When time (t mod bn(7) + bos(0)) == 0 then test others for (t mod bnum + bos) == bnum
         */
        long time = MinMatch(schd);
        System.out.println("\nPart 2 Time - " + time); // Confirmed - Part 2 Time - ??(1068781)
    }

    // ----------------------------------- Part 1 & 2 ----------------------------------

    private static int[] ParceIn(String readIn){
        int len = 0;    // Length of input schd
        for(int i = 0; i < readIn.length(); i++) if(readIn.charAt(i) == ',') len++;
        len++;
        int schd[] = new int[len];
        String str;
        int beg = 0, end = 0;
        for(int i = 0; i < len; i++){
            end = readIn.indexOf(',', end);
            if(end == -1) end = readIn.length();
            str = readIn.substring(beg, end).trim();
            if(!str.equals("x")){
                schd[i] = Integer.parseInt(str);
            }
            beg = ++end;
        }
        return schd;
    }

    private static void FindClosest(int dTime, int schd[], int ans[]){
        int len = schd.length;     // Length of input schd
        int maxNdx = 0;
        int psntTmp = 0, minTmp = 1000;
        int i = 0;
        for(; i < len; i++){
            if(schd[i] != 0){
                psntTmp = schd[i] - (dTime % schd[i]);
                if(psntTmp < minTmp){
                    maxNdx = i;
                    minTmp = psntTmp;
                }
            }
        }
        ans[0] = maxNdx;
        ans[1] = minTmp;
    }

    private static long MinMatch(int schd[]){
        int mxBus = 0;
        int mxBusNdx = 0;
        for(int i = 0; i < schd.length; i++){
            if(mxBus < schd[i]){
                mxBus = schd[i];
                mxBusNdx = i;
            }
        }
        long busTime = 453689516036380L;
        // long busTime = 0L;
        busTime = busTime - (busTime % mxBus) - mxBusNdx;
        boolean fnd = false;

        do{
            busTime += mxBus;
            // busTime++;
            if(CalcBus(busTime, schd[0], 0) == 0){
                fnd = true;
                for(int i = 1; i < schd.length; i++){
                    if(schd[i] > 0 ){
                        if(schd[i] != CalcBus(busTime, schd[i], i)){
                            fnd = false;
                        }
                    }
                    if(!fnd) break;
                }
            }

        }while(!fnd);
        return busTime;
    }
    private static int CalcBus(long time, int busNum, int busOS){
        int tmp = (int)(time % busNum) + busOS;
        return tmp;
    }
}