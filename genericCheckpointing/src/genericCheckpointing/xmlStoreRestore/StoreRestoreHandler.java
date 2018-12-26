package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import genericCheckpointing.xmlStoreRestore.XMLDeserializationStrat;
import genericCheckpointing.xmlStoreRestore.XMLSerializationStrat;



public class StoreRestoreHandler implements InvocationHandler{
		private FileProcessor fp;

	/**
     * StoreRestoreHandler constructor
     *
     * Creates new StoreRestoreHandler
     *
     *@param String filepath: where the objects will be read/write to/from
     *@return
     */
		public StoreRestoreHandler(String filePath){
				fp = new FileProcessor(filePath);

		}

    /**
     * Invoke function
     *
     * ised to invoke the correct strategy of checkpoint on the object depending on if
     * we are reading or writing the object
     *
     *@param Object proxy, Method m, Object args: the proxy, method being invoked, and args of object
     *@return
     */
		public Object invoke(Object proxy, Method m, Object[] args){
			String mName = m.getName();
			//System.out.println("*** " + mName + "  ***");

			if(mName.equals("readObj")){
				//System.out.println("reading object in handler");
				StrategyI strat = new XMLDeserializationStrat();
				Object obj = null;
				obj = strat.checkPoint(obj, fp);
				return obj;
			}else if(mName.equals("writeObj")){
				//System.out.println("writing object in handler");
				StrategyI strat = new XMLSerializationStrat();
				Object objType = (SerializableObject)args[0];
				strat.checkPoint(objType, fp);
				return true;
			}
			return proxy;
		}

		public void openRead(){
			fp.openRead();
		}
		public void closeRead(){
			fp.closeRead();
		}
		public void openWrite(){
			fp.openWrite();
		}
		public void closeWrite(){
			fp.closeWrite();
		}
	}