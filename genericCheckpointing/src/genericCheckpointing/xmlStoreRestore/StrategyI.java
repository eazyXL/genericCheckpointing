package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.util.FileProcessor;

public interface StrategyI{
	public Object checkPoint(Object obj, FileProcessor fp);
}