package extractor_flyweight.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jvinh
 */
public class ExtractorUtils {
    private static final String DATE_PATTERN = "yyyyMMdd";
    private static final String ASIZE_SEPARATOR = "-";

    /**
     * @param  <T> class générique
     * @param  t   type générique
     * @return     si le parametre est null ou empty
     */
    public static <T> boolean isEmpty(T t) {
	if (t instanceof String) {
	    return StringUtils.isEmpty((String) t);
	} else if (t instanceof List<?>) {
	    return CollectionUtils.isEmpty((Collection<?>) t);
	} else {
	    return t == null;
	}
    }
    
    public static String dateConvertor(Date dateToConvert) {
	DateFormat f = new SimpleDateFormat(DATE_PATTERN);
	
	return (!isEmpty(dateToConvert) ? f.format(dateToConvert) : "");
    }
    
    public static Integer extractArrayMaxSizeFromValidatorQuery(String sQuery) {
	Integer result = 0;
	if(!ExtractorUtils.isEmpty(sQuery)
		    && sQuery.startsWith("aSize")) {
	    String[] sQueryArray = sQuery.split(ASIZE_SEPARATOR);
	    
	    result = (sQueryArray.length > 2 ? Integer.valueOf(sQueryArray[2]) : 0);
	}
	return result;
    }
    
    public static String getProperty(String propertyKey) {
	String result = "";
	if(!ExtractorUtils.isEmpty(ExtractorProperties.properties)) {
	    result = ExtractorProperties.properties.getProperty(propertyKey);
	}
	return result;
    }
}