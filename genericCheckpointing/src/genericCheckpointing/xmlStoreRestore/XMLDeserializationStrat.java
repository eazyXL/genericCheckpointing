package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.FileProcessor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;


public class XMLDeserializationStrat implements StrategyI{

    /**
     * checkPoint function for Deser strat
     *
     * Reads line from file and parses the object information
     * uses java reflection to reconstruct the object and returns it
     *
     *@param Object temp: not used but follows the interface, FileProcessor FP: to read from file
     *@return Object, the reflected object
     */
	public Object checkPoint(Object temp, FileProcessor fp){
		Class tempClass = null;
		Object tempObject = null;

		fp.getLine();
		String line = fp.getLine();

		
		String className = line.substring(24, line.length()-2);
		//System.out.println("**** " + className);
		

		try{
			tempClass = Class.forName(className);
			tempObject = tempClass.newInstance();
		}catch(Exception e){
			System.err.println("error instantiating class");
		}

		while(!(line = fp.getLine()).equals("</DPSerialization>")){
			if(line.equals(" </complexType>")){
				
			}else{

			int xsiPOS = line.indexOf("xsi");
			int xsdPOS = line.indexOf("xsd");
			int beforeaValPOS = line.indexOf("\">");
			int endValPOS = line.indexOf("</");

			String fieldName = line.substring(3, xsiPOS-1);
			String fieldType = line.substring(xsdPOS+4, beforeaValPOS);
			String fieldVal = line.substring(beforeaValPOS+2, endValPOS);
			//System.out.println(fieldType);

			//System.out.println("fieldName: " + fieldName + " fieldType: " + fieldType + " fieldVal: " + fieldVal);

 
			Field field = null;
			Method method = null;

			try{
				field = tempClass.getDeclaredField(fieldName);
				Class signature = field.getType();
				method = tempClass.getMethod("set" + fieldName, signature);
			}catch(Exception e){
				System.err.println("error getting data members");
			}

			try{
				if(fieldType.equals("int")){
					
					method.invoke(tempObject, Integer.parseInt(fieldVal));

				}
				if(fieldType.equals("string")){
					method.invoke(tempObject, fieldVal);
				}
				if(fieldType.equals("long")){
					method.invoke(tempObject, Long.parseLong(fieldVal));
				}
				if(fieldType.equals("boolean")){
					method.invoke(tempObject, new Boolean(fieldVal));
				}
				if(fieldType.equals("short")){
					method.invoke(tempObject, Short.parseShort(fieldVal));
				}
				if(fieldType.equals("double")){
					method.invoke(tempObject, Double.parseDouble(fieldVal));
				}
				if(fieldType.equals("float")){
					method.invoke(tempObject, Float.parseFloat(fieldVal));
				}
				if(fieldType.equals("char")){
					method.invoke(tempObject, fieldVal.charAt(0));
				}
			}catch(Exception e){
				System.err.println("error invoking methods of class");
			}

		}

		}//while
	
		return tempObject;
	}

	


}