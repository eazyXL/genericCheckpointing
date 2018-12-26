package genericCheckpointing.visitor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;

public class PrimeVisitorImpl implements VisitorI{
	//keeps track of prime(odd) numbers found in visited objects
	int numPrime;

    /**
     * PrimeVisitorImpl constructor
     *
     * Creates and initialized PrimeVisitor
     *
     *@param 
     *@return
     */
	public PrimeVisitorImpl(){
		numPrime = 0;
	}

	 /**
     * Visit method for this visitor
     *
     * Checks to see if the object is of type first or second
     * if of type first it checks the objects, int's and longs to see if they are odd
	 *
     * If of type second then it checks the objects short field to see if its odd
     *
     *@param SerializableObject s: Object to be visited
     *@return
     */
	public void visit(SerializableObject s){
		if(s instanceof MyAllTypesFirst){
			MyAllTypesFirst m = (MyAllTypesFirst)s;

			int myInt = m.getmyInt();
			int myOtherInt = m.getmyOtherInt();
			long myLong = m.getmyLong();
			long myOtherLong = m.getmyOtherLong();

			if(myInt != 0){
				if(myInt % 2 != 0){
					numPrime++;
				}
			}
			if(myOtherInt != 0){
				if(myOtherInt % 2 != 0){
					numPrime++;
				}
			}
			if(myLong != 0){
				if(myLong % 2 != 0){
					numPrime++;
				}
			}
			if(myOtherLong != 0){
				if(myOtherLong % 2 != 0){
					numPrime++;
				}
			}

		}else{
			MyAllTypesSecond m = (MyAllTypesSecond)s;
			short myShort = m.getmyShortT();

			if(myShort != 0){
				if(myShort % 2 != 0){
					numPrime++;
				}
			}
		}
	}


	public int getTotalPrime(){
		return numPrime;
	}
	public int getTotalPal(){
		return 0;
	}

}