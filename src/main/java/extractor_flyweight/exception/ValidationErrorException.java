package extractor_flyweight.exception;

import extractor_flyweight.exception.core.AbstractException;

/**
 * @author jvinh
 */
public class ValidationErrorException extends AbstractException {

    /**
     * 
     */
    private static final long serialVersionUID = -1968209561158786335L;

    public ValidationErrorException(String message) {
	super(message);
    }

}
