package genericCheckpointing.util;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class FileProcessor {

    /**
     * Scanner to get lines
     */
    Scanner in;
    FileWriter out;
    String fileName;



    /**
     * FileProcessor constructor
     *
     * Creates scanner with an input file to read from
     *
     *@param String input: input file path
     *@return
     */
    public FileProcessor(String input){
        try{
            fileName = input;
            in = new Scanner(new File(input));
            
        }catch(Exception e){
            System.err.println("FileProcessor: input file not found with name: " + input);
        }
    }

 /**
     * Creates scanner in the FP to read from
     *
     *
     *
     *@param 
     *@return
     */
    public void openRead(){
         try{
            in = new Scanner(new File(fileName));
            
        }catch(Exception e){
            System.err.println("FileProcessor: openReadError **");
        }
    }


 /**
     * Closes the scanner that was used to read
     *
     *
     *
     *@param 
     *@return
     */
    public void closeRead(){
        try{
            in.close();
        }catch(Exception e){
            System.err.println("Scanner is null");
        }
    }


 /**
     * Opens a writer in the FP
     *
     *
     *
     *@param 
     *@return
     */
    public void openWrite(){
        try{
            out = new FileWriter(fileName, false);
            
        }catch(Exception e){
            System.err.println("FileProcessor: output creation failed **");
        }
    }

     /**
     * Close the Writer
     *
     * 
     *
     *@param 
     *@return
     */
    public void closeWrite(){
        try{
            out.close();
            
        }catch(Exception e){
            System.err.println("writer is null");
        }

    }


    /**
     * Gets next line
     *
     * Gets next line of file unless it is empty or reached EOF
     *
     *@param
     *@return String: line that was read or null if EOF
     */
    public String getLine(){
        if(this.in.hasNext()){
            return this.in.nextLine();
        }else{
            return null;
        }
    }

 /**
     * Writes line to file
     *
     *
     *@param String line: line to be written
     *@return
     */
    public void writeLine(String line){
        try{
            out.write(line + "\n");
        }catch(Exception e){
            System.err.println("ERROR in file write");
        }
    }
}