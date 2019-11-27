package extractor_flyweight.model.data.core;

import java.util.ArrayList;
import java.util.List;

import extractor_flyweight.model.data.core.interfaces.IComponent_Data;

/**
 * @author jvinh
 */
public abstract class ListComponent_Data extends ArrayList<IComponent_Data> implements IComponent_Data {

    /**
     * 
     */
    private static final long serialVersionUID = 2963173531800852252L;

    @Override
    public List<String> GetLine() {
	List<String> result = new ArrayList<>();
	for(IComponent_Data iComponentData : this) {
	    result.addAll(iComponentData.GetLine());
	}
	return result;
    }
}
