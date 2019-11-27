package extractor_flyweight.model.entity;

import java.util.ArrayList;
import java.util.List;

import extractor_flyweight.exception.ValidationErrorException;
import extractor_flyweight.model.action.core.interfaces.IAction_Model;

/**
 * @author jvinh
 */
public class ListExtractorEntity extends ArrayList<ExtractorEntity> implements IAction_Model {

    /**
     * 
     */
    private static final long serialVersionUID = -6831416132117598225L;

    public ListExtractorEntity() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public List<String> generationAction() {
	List<String> result = new ArrayList<>();

	for(ExtractorEntity extractorEntity : this) {
	    result.addAll( extractorEntity.generationAction() );
	}
	return result;
    }

    @Override
    public void validate() throws ValidationErrorException {
	validate("");
    }

    @Override
    public void validate(String rootClass) throws ValidationErrorException {
	for(ExtractorEntity extractorEntity : this) {
	    extractorEntity.validate(rootClass);
	}
    }

    @Override
    public String getCodeAction() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getCodeReference() {
	// TODO Auto-generated method stub
	return null;
    }

}
