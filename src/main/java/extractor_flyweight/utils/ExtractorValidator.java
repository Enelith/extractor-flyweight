package extractor_flyweight.utils;

import java.lang.reflect.Field;
import java.util.Collection;

import extractor_flyweight.exception.RuleException;

/**
 * @author jvinh
 */
public class ExtractorValidator {
    private static final String ASIZE_SEPARATOR = "-";

    @SuppressWarnings("unchecked")
    public static void process(String sQuery, Field f, Object fieldValue) throws RuleException {
	if (!ExtractorUtils.isEmpty(sQuery)) {
	    if ("notNull".equals(sQuery)
			&& ExtractorUtils.isEmpty(fieldValue)) {
		throw new RuleException(f.getName() + " (" + f.getType() + ") cannot be null (or empty)");
	    } else if ("null".equals(sQuery)
			&& !ExtractorUtils.isEmpty(fieldValue)) {
		throw new RuleException(f.getName() + " (" + f.getType() + ") has to be null (or empty)");
	    }
	    if (sQuery.startsWith("aSize")) {
		if (Collection.class.isAssignableFrom(f.getType())) {
		    /**
		     * Query format : aSize-X or aSize-X-Y
		     */
		    String[] sQueryArray = sQuery.split(ASIZE_SEPARATOR);

		    Integer minRange = Integer.valueOf(sQueryArray[1]);
		    Integer maxRange = (sQueryArray.length > 2
				? Integer.valueOf(sQueryArray[2])
				: 0);

		    Integer currentSize = (!ExtractorUtils.isEmpty(fieldValue)
				? ((Collection<Object>) fieldValue).size()
				: 0);

		    if (minRange > 0
				&& currentSize < minRange) {
			throw new RuleException(f.getName() + " (" + f.getType() + ") size should be between "
						+ minRange + " and " + maxRange + " (FOUND : " + currentSize + ")");
		    }

		    if (maxRange > 0
				&& currentSize > maxRange) {
			throw new RuleException(f.getName() + " (" + f.getType() + ") size should be between "
						+ minRange + " and " + maxRange + " (FOUND : " + currentSize + ")");
		    }
		} else {
		    throw new RuleException(f.getName() + " (" + f.getType() + ") is not an ArrayList");
		}
	    }
	}
    }
}