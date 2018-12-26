package genericCheckpointing.util;
import genericCheckpointing.visitor.PrimeVisitorImpl;
import genericCheckpointing.visitor.PalindromVisitorImpl;
import java.util.Vector;
import genericCheckpointing.visitor.VisitorI;



public class VisitorWorker{
	//list of serializable objects
	Vector<SerializableObject> objList;
	//totalPrime vals found
	int totalPrime;
	//total palindromes found
	int totalPal;


    /**
     * VisitorWorker constructor
     *
     * sets the objects vector and initializes vars
     *
     *@param Vector - of serializable objects to be visited
     *@return
     */
	public VisitorWorker(Vector<SerializableObject> v){
		totalPal = 0;
		totalPrime = 0;
		objList = v;
	}


    /**
     * accept function for pattern
     *
     * Visits each object and then gets the total number of
     * palindromes and primes found by the visitor and adds to global
     *
     *@param Visitor visitor: visitor to be used
     *@return
     */
	public void accept(VisitorI visitor){
		for (int i = 0; i < objList.size(); i++) {
			visitor.visit(objList.get(i));
		}
		totalPrime += visitor.getTotalPrime();
		totalPal += visitor.getTotalPal();
	}

	public int getTotalPrime(){
		return totalPrime;
	}
	public int getTotalPal(){
		return totalPal;
	}



}