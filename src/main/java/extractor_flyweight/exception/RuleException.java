package extractor_flyweight.exception;

import extractor_flyweight.exception.core.AbstractException;

/**
 * @author jvinh
 */
public class RuleException extends AbstractException {

    /**
     * 
     */
    private static final long serialVersionUID = -8392754202944398353L;

    public RuleException(String message) {
	super(message);
    }

}
