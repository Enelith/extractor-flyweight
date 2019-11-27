package extractor_flyweight.exception.core;

/**
 * @author jvinh
 */
public abstract class AbstractException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 873644955757576561L;
    
    /**
     * Exception message
     */
    private String message;
    
    /**
     * Instanciates a new ExtractorException
     * 
     * @param message the message
     */
    public AbstractException(String message) {
	super();
	this.message = message;
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
	return message;
    }
    
    /**
     * Set the message
     * 
     * @param message the new message
     */
    public void setMessage(String message) {
	this.message = message;
    }
}
