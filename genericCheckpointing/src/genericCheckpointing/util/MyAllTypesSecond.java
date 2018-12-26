package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject{

	double myDoubleT, myOtherDoubleT;
	short myShortT;
	char myCharT;
	float myFloatT;

	public MyAllTypesSecond(){

	}

	 /**
     * MyAllTypesSecond Constructor
     *
     * If values less than 10 it does not set them
     *
     *@param args passed in to be set in the object
     *@return
     */
	public MyAllTypesSecond(double myDoubleTIn, double myOtherDoubleTIn, 
							float myFloatTIn, short myShortTIn, char myCharTIn){

		myShortT = myShortTIn;
		if(myOtherDoubleTIn >= 10){
		myOtherDoubleT = myOtherDoubleTIn;
		}
		if(myDoubleTIn >= 10){
		myDoubleT = myDoubleTIn;
		}
		myFloatT = myFloatTIn;
		myCharT = myCharTIn;

	} 

	/**
     * Modified MyAllTypesSecond Constructor
     *
     * Used for debugging
     *
     *@param args passed in to be set in the object
     *@return
     */
	public MyAllTypesSecond(double myDoubleTIn, 
							float myFloatTIn, short myShortTIn, char myCharTIn){

		myShortT = myShortTIn;
		myDoubleT = myDoubleTIn;
		myFloatT = myFloatTIn;
		myCharT = myCharTIn;

	}

	public short getmyShortT(){
		return myShortT;
	}
	public void setmyShortT(short i){
		myShortT = i;
	}

	public double getmyOtherDoubleT(){
		return myOtherDoubleT;
	}
	public void setmyOtherDoubleT(double i){
		myOtherDoubleT = i;
	} 

	public double getmyDoubleT(){
		return myDoubleT;
	}
	public void setmyDoubleT(double l){
		myDoubleT = l;
	}

	public float getmyFloatT(){
		return myFloatT;
	}
	public void setmyFloatT(float l){
		myFloatT = l;
	}

	public char getmyCharT(){
		return myCharT;
	}
	public void setmyCharT(char s){
		myCharT = s;
	}

	 /**
     * Override toString
     *
     * Prints the object and its data members
     *
     *@param 
     *@return
     */
	@Override
	public String toString(){
		return ("typeSecond-> myDoubleT: " + myDoubleT + " | myOtherDoubleT: " + myOtherDoubleT + " | myFloatT: " + myFloatT + " | myShortT: " + myShortT + " | myCharT: " + myCharT);
	}


	 /**
     * Override equals
     *
     * used to compare old and new objects
     *
     *@param obj - obj to compare
     *@return
     */
	@Override
	public boolean equals(Object obj){
		boolean temp = true;
		MyAllTypesSecond m = (MyAllTypesSecond)obj;
	
		if(m.getmyDoubleT() != myDoubleT){
			temp = false;
		}
		if(m.getmyOtherDoubleT() != myOtherDoubleT){
			temp = false;
		}
		if(m.getmyShortT() != myShortT){
			temp = false;
		}
		if(m.getmyCharT() != myCharT){
			temp = false;
		}
		if(m.getmyFloatT() != myFloatT){
			temp =false;
		}

		if(temp == true){
			return true;
		}else{
			return false;
		}

	}

	 /**
     * Hashcode implementation
     *
     *
     *@param 
     *@return
     */
	@Override
	public int hashCode(){
		return (int)(((((myDoubleT * 3.1415926) + myFloatT) *20.3) + myCharT)/2.6);
	}

}