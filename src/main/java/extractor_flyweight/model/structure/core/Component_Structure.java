package extractor_flyweight.model.structure.core;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import extractor_flyweight.model.core.ExtractorModel;
import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.model.structure.core.interfaces.IComponent_Structure;
import extractor_flyweight.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public abstract class Component_Structure extends ExtractorModel implements IComponent_Structure {
    private static final String LOGGER_HEADER = "[" + Component_Structure.class.getName() + "] ";

    {
	// Initialize fields value with .properties matching key/value
	if (!ExtractorUtils.isEmpty(this.getClass().getDeclaredFields())) {
	    for (Field f : this.getClass().getDeclaredFields()) {
		// Non final fields only
		if (!Modifier.isFinal(f.getModifiers())) {
		    f.setAccessible(true);

		    try {
			f.set(this, ExtractorUtils.getProperty(this.getClass().getSimpleName() + "." + f.getName()));
		    } catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error(LOGGER_HEADER
				     + "(IllegalArgumentException | IllegalAccessException) Error while initializing "
				     + this.getClass().getSimpleName()
				     + " : "
				     + e.getMessage());
		    }
		}
	    }
	}
    }

    public Component_Structure() {
	super();
    }

    @Override
    public List<String> generateParticle(IComponent_Data data, boolean isFullDisplay) {
	logging(LOGGER_HEADER + " Call for method : " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	// Each rows will start with the data class type name
	String result = data.getClass().getSimpleName();

	String fieldData_Value = null;
	Integer fieldValue_Length = 0;

	Field fieldStructure = null;
	String fieldStructure_Value = null;

	for (Field fData : data.getClass().getDeclaredFields()) {
	    fData.setAccessible(true);

	    // Retrieve field Value
	    try {
		fieldData_Value = (String) fData.get(data);
		fieldData_Value = (!ExtractorUtils.isEmpty(fieldData_Value)
			    ? fieldData_Value
			    : "");
	    } catch (IllegalArgumentException | IllegalAccessException e) {
		logger.error(LOGGER_HEADER
			     + "(IllegalArgumentException | IllegalAccessException) "
			     + new Object() {
			     }.getClass().getEnclosingMethod().getName()
			     + " : "
			     + e.getMessage());
	    }

	    // Retrieve field matching value (initialized through the .properties)
	    try {
		fieldStructure = this.getClass().getDeclaredField(fData.getName());
		fieldStructure.setAccessible(true);
		fieldStructure_Value = (String) fieldStructure.get(this);
	    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		logger.error(LOGGER_HEADER
			     + "(IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException) "
			     + new Object() {
			     }.getClass().getEnclosingMethod().getName()
			     + " : "
			     + e.getMessage());
	    }

	    fieldValue_Length = Math.max(0,
			!ExtractorUtils.isEmpty(fieldStructure_Value)
				    ? Integer.parseInt(fieldStructure_Value)
				    : -1);

	    if (fieldValue_Length > 0) {
		String lpadFiller = ExtractorUtils
			    .getProperty(this.getClass().getSimpleName() + "." + fData.getName() + "." + "lpad.filler");
		String rpadFiller = ExtractorUtils
			    .getProperty(this.getClass().getSimpleName() + "." + fData.getName() + "." + "rpad.filler");

		if (!ExtractorUtils.isEmpty(lpadFiller)) {
		    // Lpad field value
		    fieldData_Value = StringUtils.leftPad(fieldData_Value, fieldValue_Length, lpadFiller);
		} else {
		    // Rpad fiel value
		    fieldData_Value = StringUtils.rightPad(fieldData_Value,
				fieldValue_Length,
				(!ExtractorUtils.isEmpty(rpadFiller)
					    ? rpadFiller
					    : ""));
		}

		// Limit field size based on the .properties definition (values initialized into
		// the _Structure files)
		fieldData_Value = fieldData_Value.substring(0, fieldValue_Length);

		if (isFullDisplay) {
		    result += (!ExtractorUtils.isEmpty(result)
				? "|"
				: "") + fieldData_Value;
		} else {
		    result += fieldData_Value;
		}
	    }
	}

	logging(LOGGER_HEADER + " Class " + data.getClass().getName() + " value = {" + result + "}" + (isFullDisplay
		    ? " (Debug mode activated : remote \"|\" for real result)"
		    : ""));

	return new ArrayList<String>(
		    Arrays.asList(result));
    }
}
