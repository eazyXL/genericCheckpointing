package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.FileProcessor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class XMLSerializationStrat implements StrategyI{

	 /**
     * checkPoint function for serialization
     *
     * Takes in an object of given type and gets the objects class information and fields
     * writes the information to file in pseudoXML format
     *
     *@param Object complexType: the object to be broken up and written to file, FileProcessor FP: to write info to file
     *@return
     */
	public Object checkPoint(Object complexType, FileProcessor fp){
		
		Field[] fieldList = complexType.getClass().getDeclaredFields();
		fp.writeLine("<DPSerialization>");
		Object temp = complexType.getClass();
		String tmp = temp.toString();
		tmp = tmp.substring(6);
		fp.writeLine(" <complexType xsi:type=\"" + tmp + "\">");

		for(int j = 0; j < fieldList.length; j++){
			String type = fieldList[j].getType().toString();
			String varName = fieldList[j].getName();

			

			

			try{

				Method method = complexType.getClass().getMethod("get" + varName);
				Object value = method.invoke(complexType);

				if(type.equals("int")){
					if((int)value >= 10){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (int)value + "</" + varName + ">");
					}
				}
				if(type.equals("long")){
					if((long)value >= 10){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (long)value + "</" + varName + ">");
					}
				}
				if(type.equals("class java.lang.String")){
					if((String) value != ""){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:string" + "\">" + (String)value + "</" + varName + ">");
					}
				}
				if(type.equals("boolean")){
					if(1 == 1){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (boolean)value + "</" + varName + ">");
					}
				}
				if(type.equals("double")){
					if((double)value >= 10){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (double)value + "</" + varName + ">");
					}
				}
				if(type.equals("float")){
					if((float)value >= 10){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (float)value + "</" + varName + ">");
					}
				}
				if(type.equals("short")){
					if((short)value >= 10){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (short)value + "</" + varName + ">");
					}
				}
				if(type.equals("char")){
					if(1 == 1){
						fp.writeLine("  <" + varName + " xsi:type=\"xsd:" + type + "\">" + (char)value + "</" + varName + ">");
					}
				}




			}catch(Exception e){
				System.err.println("error serialization");
			}//catch

		}//for
		fp.writeLine(" </complexType>");
		fp.writeLine("</DPSerialization>");
		return 1;
	}//object
}