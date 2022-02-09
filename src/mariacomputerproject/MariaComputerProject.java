/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariacomputerproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Carlos Garcia
 */
public class MariaComputerProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        //Memory Address with 1000
        int memoryAddress[] = new int[1000];
        //Values for PC, AC, IR, MBR, MAR
        int PC = 0, AC = 0, IR = 0, MBR = 0, MAR = 0;
        //Counter
        int i = 0;
        //Scanner to scan the text file
        Scanner keyboard = new Scanner(System.in);
        //Open the txt file
        File multiplyFile = new File("multiply.txt");
        //Reads the content
        Scanner inputFile = new Scanner(multiplyFile);
        //Reads the lines and puts them inside of the memmoryAddress
        String line = inputFile.nextLine();
        
        while(inputFile.hasNext())
        {
            memoryAddress[i] = Integer.parseInt(line);
            i++;
            line = inputFile.nextLine();
            if(inputFile.hasNext() == false)
            {
                memoryAddress[i] = Integer.parseInt(line);
            }
        }
        //Closes the file
        inputFile.close();
        //Creates a boolean for the shutdown
        boolean Shutdown = false;
        //Start of the Computer
        while(Shutdown == false)
        {
            int HEX = memoryAddress[PC];
            int R = (HEX % 1000) / 100;
            int R2 = HEX % 1000;
            HEX = HEX/1000;
            if(HEX == 1)
            {
               MAR = PC;
               IR = memoryAddress[MAR];
               PC = PC + 1;
               MAR = IR% 1000;
               MBR = memoryAddress[MAR];
               AC = MBR;
            }
            else if(HEX == 2)
            {
               MAR = PC;
               IR = memoryAddress[MAR];
               PC = PC + 1;
               MAR = IR% 1000;
               MBR = AC;
               memoryAddress[MAR] = MBR;
            }
            else if(HEX == 3)
            {
               MAR = PC;
               IR = memoryAddress[MAR];
               PC = PC + 1;
               MAR = IR% 1000;
               MBR = memoryAddress[MAR];
               AC = AC + MBR;
            }
            else if(HEX == 4)
            {
               MAR = PC;
               IR = memoryAddress[MAR];
               PC = PC + 1;
               MAR = IR% 1000;
               MBR = memoryAddress[MAR] % 1000;
               AC = AC - MBR;
            }
            else if(HEX == 5)
            {
                System.out.println("Input the value you would like to use: ");
                AC = keyboard.nextInt();
                PC = PC + 1;
            }
            else if(HEX == 6)
            {
                System.out.println(AC);
                PC = PC + 1;
            }
            else if(HEX == 7)
            {
                Shutdown = true;
            }
            else if(HEX == 8)
            {
                if(R == 0)
                {
                    if(AC < 0)
                    {
                        PC = PC +1;
                        PC = PC +1;
                    }
                    else{
                        PC = PC +1;
                    }
                }
                else if(R == 1)
                {
                    if(AC == 0)
                    {
                        PC = PC +1;
                        PC = PC +1;
                    }
                    else{
                        PC = PC +1;
                    }
                }
                else if(R == 2)
                {
                    if(AC > 0)
                    {
                        PC = PC + 1;
                        PC = PC +1;
                    }
                    else{
                        PC = PC +1;
                    }
                }
                else{
                    PC = PC + 1;
                }
            }
            else if(HEX == 9)
            {
                PC = R2;
            }
        
        
        }
    }
}

