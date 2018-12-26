package genericCheckpointing.visitor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.SerializableObject;

public interface VisitorI{

	public void visit(SerializableObject s);
	public int getTotalPrime();
	public int getTotalPal();

}