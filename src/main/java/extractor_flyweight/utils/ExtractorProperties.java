package extractor_flyweight.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jvinh
 */
public class ExtractorProperties {
    private static final String LOGGER_HEADER = "[" + ExtractorProperties.class.getName() + "] ";
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ExtractorProperties.class);

    private static final String DEFAULT_FILENAME_PROPERTIES = "extractor_flyweight.application.properties";
    private static final String VM_EXTERNALISE_VAR_PATH = "extractor_flyweight.externalized.properties";
    
    public static Properties properties;
    
    static {
	properties = load();
    }
    
    public ExtractorProperties() throws Exception {
	throw new Exception("ExtractorProperties cannot be instantiate");
    }

    /**
     * Charge la liste des propriétés contenu dans le fichier spécifié
     *
     * @return un objet Properties contenant les propriétés du fichier
     */
    public static Properties load() {
	logger.debug(LOGGER_HEADER + "Initialisation " + ExtractorProperties.class.getName());

	Properties properties = null;
	InputStream input = null;

	try {
	    properties = new Properties();
	    input = ExtractorProperties.class.getResourceAsStream("/" + DEFAULT_FILENAME_PROPERTIES);
	    properties.load(input);

	    logger.debug(LOGGER_HEADER + "Checking externalized properties for VM arg : " + VM_EXTERNALISE_VAR_PATH);
	    if (!ExtractorUtils.isEmpty(System.getProperty(VM_EXTERNALISE_VAR_PATH))) {
		Path pathExternalise = Paths.get(System.getProperty(VM_EXTERNALISE_VAR_PATH));

		logger.debug(LOGGER_HEADER + "Loading externalized properties at : "
			     + pathExternalise.toString());
		if (Files.exists(pathExternalise, new LinkOption[] {})
			    && Files.isReadable(pathExternalise)) {
		    FileInputStream fis = new FileInputStream(pathExternalise.toFile());
		    properties.load(fis);
		    fis.close();
		} else {
		    logger.debug(LOGGER_HEADER
				 + "Failed to load externalized properties - file does not exist or is not readable");
		}
	    }
	} catch (IOException e) {
	    logger.error(LOGGER_HEADER + "(IOException) Error while initializing " + ExtractorProperties.class.getName()
			 + " : " + e.getMessage());
	} finally {
	    if (input != null) {
		try {
		    input.close();
		} catch (IOException e) {
		    logger.error(LOGGER_HEADER
				 + "(IOException) Error while initializing " + ExtractorProperties.class.getName()
				 + " (Close InputStream) : "
				 + e.getMessage());
		}
	    }
	}

	return properties;
    }
}
