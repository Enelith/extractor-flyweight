package extractor_flyweight.model.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jvinh
 */
public abstract class ExtractorModel {
    protected static final Logger logger = (Logger) LoggerFactory.getLogger(ExtractorModel.class);
    
    protected boolean fullDisplayMode = false;
    
    protected void logging(String message) {
	if(isFullDisplayMode()) {
	    logger.info(message);
	}
	else {
	    logger.debug(message);
	}
    }

    public boolean isFullDisplayMode() {
        return fullDisplayMode;
    }

    public void setFullDisplayMode(boolean fullDisplayMode) {
        this.fullDisplayMode = fullDisplayMode;
    }
    
}
