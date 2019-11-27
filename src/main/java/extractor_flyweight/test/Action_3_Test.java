package extractor_flyweight.test;

import java.util.Date;
import java.util.List;

import extractor_flyweight.exception.ValidationErrorException;
import extractor_flyweight.model.action.Action_3;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_3;
import extractor_flyweight.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public class Action_3_Test {

    public static void main(String[] args) {
	boolean fullDisplayMode = true;
	
	Action_3 action = new Action_3();
	action.setFullDisplayMode(fullDisplayMode);

	/***********************************/
	Component_Data_1 component_1 = new Component_Data_1();
	component_1.setFullDisplayMode(action.isFullDisplayMode());
	component_1.setCodeAction(action.getCodeAction());
	component_1.setCodeReference(action.getCodeReference());
	component_1.setDateBegin(ExtractorUtils.dateConvertor(new Date()));

	/***********************************/
	Component_Data_3 component_3 = new Component_Data_3();
	component_3.setFullDisplayMode(action.isFullDisplayMode());
	component_3.setRandomInfo("Random Info 2");
	component_3.setRandomText("Random Text associed");
	component_3.setRandomWhatever("Things to do");

	/***********************************/
	action.setComponent_1(component_1);
	action.setComponent_3(component_3);
	
	try {
	    action.validate();
	} catch (ValidationErrorException e) {
	    System.out.println("ERROR : " + e.getMessage());
	}
	
	List<String> result = action.generationAction();
	result.stream().forEach(a -> {
	    System.out.println(a);
	});
    }

}
