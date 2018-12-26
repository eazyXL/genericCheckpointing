package genericCheckpointing.visitor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;

public class PalindromVisitorImpl implements VisitorI{
	//keeps track of each palindrome found
	int totalPal;

    /**
     * PalindromVisitorImpl constructor
     *
     * Initialized var
     *
     *@param 
     *@return
     */
	public PalindromVisitorImpl(){
		totalPal = 0;
	}


	//algorithm influnced by https://stackoverflow.com/questions/4138827/check-string-for-palindrome

	 /**
     * Visit function
     *
     * Checks each object if it is of type First
     * as first is the only type with a string, it then uses an algorithm
     * inspired from the link above to check the string data member for palindrome
     *
     *@param SerializableObject s: object to visit
     *@return
     */
	public void visit(SerializableObject s){
		if(s instanceof MyAllTypesFirst){

			MyAllTypesFirst m = (MyAllTypesFirst)s;
			String temp = m.getmyString();

			boolean isPal = true;

			int i = 0;
			int j = temp.length() - 1;

			while(j > i){
				if(temp.charAt(i) != temp.charAt(j)){
					isPal = false;
				}
				++i;
				--j;
			}

			if(isPal){
				totalPal++;
			}
		}

	}

	public int getTotalPal(){
		return totalPal;
	}
	public int getTotalPrime(){
		return 0;
	}


}