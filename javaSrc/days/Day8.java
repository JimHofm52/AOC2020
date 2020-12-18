package days;

public class Day8 {

    public static void update(String fileInfo[]) {
        int acc = 0;    //Accumlator
                                                //Opcodes - 0=acc, 1=jmp, 2=nop
        int opsAcc[][] = new int[2][650];       //Opcode[0][] / Acc[1][]
        boolean flipped[] = new boolean[650];   //Part 2 track if flipping op has has been tried

        ParceCodes(fileInfo, opsAcc);   //Split input into [0]opCode and [1]acc or jmp value

        acc =  FindLoop(opsAcc, flipped, false);        //Part 1
        System.out.println("\n\nAccumulator - " + acc); //Part 1

        // Part 2
        int nxtCnt = 0;     //Count trys.  No more than arrays.
        do{
            nxtCnt++;
            acc = FindLoop(opsAcc, flipped, true);
        //continue if end of program[0][617(9)] initialized (-2) and LT 650 trys (safety)
        }while(opsAcc[0][617] < 0 && nxtCnt < opsAcc[0].length); 

        System.out.println("\n\nAccumulator - " + acc);  //Part 2
    }

    /**
     * Parce input and split to:
     * ops value[0].  0 = add to acc cmd, 1 = jmp to offset cmd, 2 = nop cmd
     * acc value[1], acc value or jmp offset
     * 
     * @param fileInfo      // Input
     * @param opsAcc        // opCode[0][] and acc/jmp[1][] value
     */
    private static void ParceCodes(String fileInfo[], int opsAcc[][]){
        String sTmp = "";
        int ndx = 0;

        do{
            sTmp = fileInfo[ndx].substring(0,3);    //Get opcode
            if(sTmp.contains("acc")){               //0 = acc
                opsAcc[0][ndx] = 0;
            }else if(sTmp.contains("jmp")){         //1 = jmp
                opsAcc[0][ndx] = 1;
            }else{
                opsAcc[0][ndx] = 2;                 //2 = nop
            }
            opsAcc[1][ndx] = Integer.parseInt(fileInfo[ndx].substring(4));   //Get acc value
            ndx++;
        }while(fileInfo[ndx].length() > 0);

        // initialize the rest of the array, just in case
        for( ; ndx < opsAcc[0].length; ndx++){
            opsAcc[0][ndx] = -1;     //[0] is opcode
            opsAcc[1][ndx] = 0;      //[1] is acc or jmp value
        }
    }

    //---------------------------  Part 1 and 2 ---------------------------------------------- 

    /**
     * Execute code.  Stop when it starts looping or reaches end of code
     * and return accumlated value to that point.
     * 
     * @param opsAcc    //Array of opCode[0] and acc or jmp[1] values
     * @param flipped   //Has an op been flipped to try to correct.  Part 2
     * @param chkFlip   //Used to run for part 2 only
     * @return
     */
    private static int FindLoop(int opsAcc[][], boolean flipped[], boolean chkFlip){
        int ptr = 0;    //pointer to opsAcc input
        int exe = 0;    //execution pointer
        int exeTrkr[] = new int[650];   //Used to track execution repeat
        int acc = 0;    //Accumulation
        int opCode = 2; //op code initialize as nop;

        do{
            exe++;
            exeTrkr[ptr] = exe;         //Track execution order
            opCode = opsAcc[0][ptr];    //Get opCode
            //Part 2 - Flip if opCode is 1 or 2 and not flipped before AND requested
            if(opCode > 0 && !flipped[ptr] && chkFlip){
                opCode++;                   //Flip opCode 1 to 2 
                if( opCode > 2) opCode = 1; //or 2 to 1
                flipped[ptr] = true;        //Flag this op has been tried
                chkFlip = false;            //Only do 1 per pass
            }
            switch(opCode){
                case 0:     //acc - add [1] to accumulator and step 1
                    acc += opsAcc[1][ptr];
                    ptr++;
                break;
                case 1:     //jmp - jump to present location + offset [1]
                    ptr += opsAcc[1][ptr];
                break;
                case 2:     //nop - no operation, just step 1
                    ptr++;
            }
        //continue if next location was not already used and has code (end of program).
        }while(exeTrkr[ptr] == 0 && opsAcc[0][ptr] != -1);

        if(ptr == 617) opsAcc[0][ptr] = 2;  //Flag if end of program reached 617(9).  Make EOP a nop.

        return acc;
    }
}