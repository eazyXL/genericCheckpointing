package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject{

	private int myInt;
	private int myOtherInt;
	private long myLong;
	private long myOtherLong;
	private String myString;
	private boolean myBool;

	public MyAllTypesFirst(){

	}

	 /**
     * MyAllTypesFirst Constructor
     *
     * If values less than 10 it does not set them
     *
     *@param args passed in to be set in the object
     *@return
     */
	public MyAllTypesFirst(int myIntIn, int myOtherIntIn, long myLongIn, 
							long myOtherLongIn, String myStringIn, boolean myBoolIn){
		if(myIntIn >= 10){
		myInt = myIntIn;
		}
		if(myOtherIntIn >= 10){
		myOtherInt = myOtherIntIn;
		}
		if(myLongIn >= 10){
		myLong = myLongIn;
		}
		if(myOtherLongIn >= 10){
		myOtherLong = myOtherLongIn;
		}
		myString = myStringIn;
		myBool = myBoolIn;
	} 

	 /**
     * Modified Constructor used for testing
     *
     * Shoudldn't be necesary as my driver created values for every data member
     *
     *@param args passed in to be set in object
     *@return
     */
	public MyAllTypesFirst(int myIntIn, long myLongIn, String myStringIn, boolean myBoolIn){

		myInt = myIntIn;
		myLong = myLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}
	/**
     * Modified Constructor used for testing
     *
     * Shoudldn't be necesary as my driver created values for every data member
     *
     *@param args passed in to be set in object
     *@return
     */
	public MyAllTypesFirst(int myIntIn, long myLongIn, long myOtherLongIn, String myStringIn, boolean myBoolIn){

		myInt = myIntIn;
		myLong = myLongIn;
		myOtherLong = myOtherLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}
	public int getmyInt(){
		return myInt;
	}
	public void setmyInt(int i){
		myInt = i;
	}

	public int getmyOtherInt(){
		return myOtherInt;
	}
	public void setmyOtherInt(int i){
		myOtherInt = i;
	} 

	public long getmyLong(){
		return myLong;
	}
	public void setmyLong(long l){
		myLong = l;
	}

	public long getmyOtherLong(){
		return myOtherLong;
	}
	public void setmyOtherLong(long l){
		myOtherLong = l;
	} 

	public String getmyString(){
		return myString;
	}
	public void setmyString(String s){
		myString = s;
	}

	public boolean getmyBool(){
		return myBool;
	}
	public void setmyBool(boolean b){
		myBool = b;
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
		return ("typeFirst-> myInt: " + myInt + " | myOtherInt: " + myOtherInt + " | myLong: " + myLong + " | myOtherLong: " + myOtherLong + " | myString: " + myString + " | myBool: " + myBool);
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
		MyAllTypesFirst m = (MyAllTypesFirst)obj;

		if(!m.getmyString().equals(myString)){
			temp = false;
		}
		if(m.getmyBool() != myBool){
			temp = false;
		}
		if(m.getmyLong() != myLong){
			temp = false;
		}
		if(m.getmyOtherLong() != myOtherLong){
			temp = false;
		}
		if(m.getmyInt() != myInt){
			temp = false;
		}
		if(m.getmyOtherInt() != myOtherInt){
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
		return (int)(((((myInt * 3.1415926) + myLong) *20.3) + myLong)/2.6);
	}

}