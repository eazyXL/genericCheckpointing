
package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.xmlStoreRestore.StrategyI;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import java.util.Vector;
import java.util.Random;
import genericCheckpointing.util.VisitorWorker;
import genericCheckpointing.visitor.PalindromVisitorImpl;
import genericCheckpointing.visitor.PrimeVisitorImpl;

// import the other types used in this file
//ant -buildfile genericCheckpointing/src/build.xml run -Darg0=serdeser -Darg1=1 -Darg2=Z:\\test.txt
public class Driver {

    public static void main(String[] args) {

        
        String mode = "", checkpointFile = "";
        int numObjects = 0;

        //parse input values
        try{
            mode = args[0];
            numObjects = Integer.parseInt(args[1]);
            checkpointFile = args[2];

        }catch(Exception e){
            System.err.println("ERROR-> MODE: serdeser/deser, NUM: int value, FILE: filepath");
            System.exit(1);
        }

        if(!mode.equals("serdeser") && !mode.equals("deser")){
            System.err.println("ERROR-> Invalid Mode");
            System.exit(1);
        }

        

        //create new proxyCreator
        ProxyCreator pc = new ProxyCreator();

       //create handler for filepath
        StoreRestoreHandler handler = new StoreRestoreHandler(checkpointFile);

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                new Class[] {
                        StoreI.class, RestoreI.class
                },
                handler
        );

        //Vector to store generated objects
        Vector<SerializableObject> vector_old = new Vector();

        
    
    //if in serialize mode then generate objects to store
    if(mode.equals("serdeser")){
        MyAllTypesFirst myFirst;
        MyAllTypesSecond  mySecond;
        handler.openWrite();

        Boolean bool = true;
        Random r = new Random();

        for (int i=0; i<numObjects; i++) {

            //boolean value based on random generated 1 or 2
            int boolInt = r.nextInt(2) +1;
            if(boolInt == 1){
                bool = true;
            }else{
                bool = false;
            }

            //build random string from alphabet
            String randomString = "";
          
            int stringLen = r.nextInt(15) + 5;

            //for the random length add random letters from alpabet
            for (int k = 0; k < stringLen; k++) {
                char t = (char)(r.nextInt(26) + 'a');
                randomString += t;
            }
            //random char for type 2
            char randomChar = (char)(r.nextInt(26) + 'a');

            //create the two objects with the values
            myFirst = new MyAllTypesFirst((int)(Math.random() * 100 + 1), (int)(Math.random() * 100 + 1), (long)(Math.random() * 7000 + 1), (long)(Math.random() * 7000 + 1), randomString, bool);
            mySecond = new MyAllTypesSecond((double)(Math.random() * 10000 + 1), (double)(Math.random() * 10000 + 1), (float) (Math.random() * 2000 + 25), (short)(Math.random() * 2000 + 25), randomChar);
            
            //add to the old vector    
            vector_old.add(myFirst);
            vector_old.add(mySecond);
    
                 
       

            //write objects using proxy
            ((StoreI) cpointRef).writeObj(myFirst, 13,  "XML");
            ((StoreI) cpointRef).writeObj(mySecond, 17, "XML");

        }
        handler.closeWrite();
    }

        
        //deser functions for reading
        handler.openRead();
        Vector<SerializableObject> vector_new = new Vector();

        SerializableObject myRecordRet = null;

        
        for (int j=0; j<2*numObjects; j++) {

            myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            //add the read object to the new vector
            vector_new.add (myRecordRet);
                //if in deser mode then print the object
                if(mode.equals("deser")){
                    System.out.println(myRecordRet);
                }
            
        }
        handler.closeRead();



        //check for mismatch between write and read
        if(mode.equals("serdeser")){    
            int numWrong = 0;
            for(int i = 0; i < 2*numObjects; i++){
                if(!vector_old.get(i).equals(vector_new.get(i))){
                    numWrong++;
                }
            }
            System.out.println(numWrong + " mismatched objects");
            
        }
    
        //create visitors
          PrimeVisitorImpl myPrimeVisitor = new PrimeVisitorImpl();
          PalindromVisitorImpl myPalindromVisitor = new PalindromVisitorImpl();  

        //create vistor worker and pass it the new vector
          VisitorWorker myVisitor = new VisitorWorker(vector_new);

          //call accept for each type of visitor
          myVisitor.accept(myPrimeVisitor);
          myVisitor.accept(myPalindromVisitor);

          //print the number of prime(odd) or palindromes
          System.out.println("Total Prime(odd): " + myVisitor.getTotalPrime());
          System.out.println("Total Palindrome: " + myVisitor.getTotalPal());


    }
}