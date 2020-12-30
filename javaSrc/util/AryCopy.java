package util;

public class AryCopy {
    public static int[] CopyInt(int[] from){
        int [] myAry = new int[from.length];
        for(int i = 0; i < from.length; i++){
            myAry[i] = from[i];
        }
        return myAry;
    }

    public static int[][] CopyInt2By(int[][] from){
        int [][] myAry = new int[from.length][from[0].length];
        for(int i = 0; i < from.length; i++){
            for(int j = 0; j < from[0].length; j++){
                myAry[i][j] = from[i][j];
            }
        }
        return myAry;
    }

    public static String[] CopyStr(String[] from){
        String [] myAry = new String[from.length];
        for(int i = 0; i < from.length; i++){
            myAry[i] = from[i];
        }
        return myAry;
    }

}