package extractor_flyweight.model.action.core.interfaces;

import java.util.List;

import extractor_flyweight.exception.ValidationErrorException;

/**
 * @author jvinh
 */
public interface IAction_Model {
    List<String> generationAction();

    void validate() throws ValidationErrorException;
    void validate(String rootClass) throws ValidationErrorException;
    
    String getCodeAction();
    String getCodeReference();
}
