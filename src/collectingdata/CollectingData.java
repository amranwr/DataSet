/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectingdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amr
 */
public class CollectingData {
    private static File file  = new File("data.txt");
    public static boolean checkFileDuplication(String name , String input ){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = bufferedReader.readLine();
            while(line  != null ){
                if(line.equals(input)){
                    return false;
                }
                line = bufferedReader.readLine();
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CollectingData.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    public static void writeOnFile(String name, String input){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            bufferedWriter.write(input+"\n");
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(CollectingData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("input name and type 'e' to exit");
        String input ;
        while(true){
            System.out.print("Enter your input :");
            input = in.nextLine();
            if(input.toLowerCase().equals("e")){
                System.out.println("Bye +_+ ");
                return ;
            }else{
                if(checkFileDuplication("data.txt",input)){
                    writeOnFile("data.txt",input);
                    System.out.println("done....");
                }else{
                    System.out.println("invalid input......");
                }
            }
        }
         
    }
    
}
