package days;

public class Day8 {

    public static void update(String fileInfo[]) {
                                                //Opcodes - 0=acc, 1=jmp, 2=nop
        int opsAccLst[][] = new int[3][650];    //Opcode / Acc / Last position

        ParceCodes(fileInfo, opsAccLst);
        // FindLoop(opsAccLst);

        System.out.println("\n\nAccumulator - " + FindLoop(opsAccLst));

        int a = 0;
    }

    private static void ParceCodes(String fileInfo[], int opsAccLst[][]){
        String sTmp = "";
        int ndx = 0;

        do{
            sTmp = fileInfo[ndx].substring(0,3);      //Get opcode
            if(sTmp.contains("acc")){               //0 = acc
                opsAccLst[0][ndx] = 0;
            }else if(sTmp.contains("jmp")){         //1 = jmp
                opsAccLst[0][ndx] = 1;
            }else{
                opsAccLst[0][ndx] = 2;                //2 = nop
            }
            opsAccLst[1][ndx] = Integer.parseInt(fileInfo[ndx].substring(4));   //Get acc value
            opsAccLst[2][ndx] = -2;
            ndx++;
        }while(fileInfo[ndx].length() > 0);

        // ndx--;
        for( ; ndx < 650; ndx++){
            opsAccLst[0][ndx] = -1;
            opsAccLst[1][ndx] = 0;
            opsAccLst[2][ndx] = -2;
        }
    }

    private static int FindLoop(int opsAccLst[][]){
        int ptr = 0;
        int exe = 0;
        int acc = 0;

        do{
            exe++;
            opsAccLst[2][ptr] = exe;
            switch(opsAccLst[0][ptr]){
                case 0:     //acc
                    acc += opsAccLst[1][ptr];
                    ptr++;
                break;
                case 1:     //jmp
                    ptr += opsAccLst[1][ptr];
                break;
                case 2:     //nop
                    ptr++;
            }

        }while(opsAccLst[2][ptr] < 0 && opsAccLst[0][ptr] != -1);

        return acc;
    }
}