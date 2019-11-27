package extractor_flyweight.model.action.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import extractor_flyweight.exception.RuleException;
import extractor_flyweight.exception.ValidationErrorException;
import extractor_flyweight.model.action.core.interfaces.IAction_Model;
import extractor_flyweight.model.core.ExtractorModel;
import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.utils.ExtractorUtils;
import extractor_flyweight.utils.ExtractorValidator;

/**
 * @author jvinh
 */
public abstract class Action_Model extends ExtractorModel implements IAction_Model {
    private static final String LOGGER_HEADER = "[" + Action_Model.class.getName() + "] ";

    private static final String VALIDATOR_QUERY_SEPARATOR = "validator.query.separator";

    private static final String CODE_ACTION = "codeAction";
    private static final String CODE_REFERENCE = "codeReference";

    public Action_Model() {
	super();
    }

    @Override
    public void validate() throws ValidationErrorException {
	validate("");
    }

    @Override
    public void validate(String rootClass) throws ValidationErrorException {
	logging(LOGGER_HEADER + "Call for method : " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	String stackError = "";

	String validatorQuerySeparator = ExtractorUtils.getProperty(VALIDATOR_QUERY_SEPARATOR);
	String[] validatorArray;

	String validatorRequest = "";
	String validatorQuery = "";
	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    try {
		Object fieldValue = f.get(this);

		validatorRequest = (!ExtractorUtils.isEmpty(rootClass)
			    ? rootClass + "."
			    : "") + this.getClass().getSimpleName() + "." + f.getName();
		validatorQuery = ExtractorUtils.getProperty(validatorRequest);
		logging(LOGGER_HEADER + "Validator : " + validatorRequest + " => " + validatorQuery);

		if (!ExtractorUtils.isEmpty(validatorQuery)) {
		    validatorArray = validatorQuery.split(validatorQuerySeparator);

		    for (String q : validatorArray) {
			if (!ExtractorUtils.isEmpty(q)) {
			    /**
			     * q possible values = notNull, null, aSize-X, aSize-X-Y
			     */
			    try {
				ExtractorValidator.process(q, f, fieldValue);
			    } catch (RuleException e) {
				stackError += (!ExtractorUtils.isEmpty(stackError)
					    ? " ### "
					    : "") + e.getMessage();
			    }
			}
		    }
		}

		if (IAction_Model.class.isAssignableFrom(f.getType())
			    && !ExtractorUtils.isEmpty(fieldValue)) {
		    try {
			((IAction_Model) fieldValue).validate(this.getClass().getSimpleName() + "." + f.getName());
		    } catch (ValidationErrorException e) {
			stackError += (!ExtractorUtils.isEmpty(stackError)
				    ? " ### "
				    : "") + e.getMessage();
		    }
		}
	    } catch (IllegalArgumentException | IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalArgumentException | IllegalAccessException) "
			     + e.getMessage());
	    }
	}

	if (!ExtractorUtils.isEmpty(stackError)) {
	    throw new ValidationErrorException(LOGGER_HEADER + "(ValidatorErrorException) "
					       + (!ExtractorUtils.isEmpty(rootClass)
							   ? rootClass + "."
							   : "")
					       + this.getClass().getSimpleName()
					       + " validation recap : "
					       + stackError);
	}
    }

    @Override
    public List<String> generationAction() {
	logging(LOGGER_HEADER + " Call for method : " + new Object() {
	}.getClass().getEnclosingMethod().getName());

	List<String> result = new ArrayList<>();

	for (Field f : this.getClass().getDeclaredFields()) {
	    f.setAccessible(true);

	    logging(LOGGER_HEADER + "Field " + f.getName() + " type : " + f.getType());

	    try {
		Object fieldValue = f.get(this);

		if (!ExtractorUtils.isEmpty(fieldValue)) {
		    if (Collections.class.isAssignableFrom(f.getType())) {
			System.out.println(f.getName() + " (" + f.getType() + ") is an Array");
		    }
		    if (IComponent_Data.class.isAssignableFrom(f.getType())) {
			result.addAll(((IComponent_Data) fieldValue).GetLine());
		    } else if (IAction_Model.class.isAssignableFrom(f.getType())) {
			// WARNING : INFINITE LOOP POSSIBLE? (ex: Action_X within Action_Y ?)
			// This part focus on ExtractorEntity and ListExtratorEntity types
			result.addAll(((IAction_Model) fieldValue).generationAction());
		    }
		}
	    } catch (IllegalArgumentException | IllegalAccessException e) {
		logger.error(LOGGER_HEADER + "(IllegalArgumentException | IllegalAccessException) "
			     + e.getMessage());
	    }
	}

	return result;
    }

    @Override
    public String getCodeAction() {
	return ExtractorUtils.getProperty(this.getClass().getSimpleName() + "." + CODE_ACTION);
    }

    @Override
    public String getCodeReference() {
	return ExtractorUtils.getProperty(this.getClass().getSimpleName() + "." + CODE_REFERENCE);
    }
}
