package extractor_flyweight.test;

import java.util.Date;
import java.util.List;

import extractor_flyweight.exception.ValidationErrorException;
import extractor_flyweight.model.action.Action_1;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_2;
import extractor_flyweight.model.data.Component_Data_3;
import extractor_flyweight.model.data.list.ListComponent_Data_2;
import extractor_flyweight.model.data.list.ListComponent_Data_3;
import extractor_flyweight.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public class Action_1_Test {

    public static void main(String[] args) {
	boolean fullDisplayMode = true;
	
	Action_1 action = new Action_1();
	action.setFullDisplayMode(fullDisplayMode);

	/***********************************/
	Component_Data_1 component_1 = new Component_Data_1();
	component_1.setFullDisplayMode(action.isFullDisplayMode());
	component_1.setCodeAction(action.getCodeAction());
	component_1.setCodeReference(action.getCodeReference());
	component_1.setDateBegin(ExtractorUtils.dateConvertor(new Date()));

	/***********************************/
	ListComponent_Data_2 component_2_List = new ListComponent_Data_2();
	Component_Data_2 component_2 = new Component_Data_2();
	component_2.setFullDisplayMode(action.isFullDisplayMode());
	component_2.setLastname("DIRTY");
	component_2.setFirstname("Harry");
	component_2.setCity("San Francisco");
	component_2_List.add(component_2);

	component_2 = new Component_Data_2();
	component_2.setFullDisplayMode(action.isFullDisplayMode());
	component_2.setLastname("WAYNE");
	component_2.setFirstname("Bruce");
	component_2.setCity("Gotham");
	component_2_List.add(component_2);

	// DEVRAIT GENERER UNE ERREUR
	Component_Data_3 component_3 = new Component_Data_3();
	component_3.setFullDisplayMode(action.isFullDisplayMode());
	component_3.setRandomInfo("THIS IS COMP3");
	component_2_List.add(component_3);

	/***********************************/
	ListComponent_Data_3 component_3_List = new ListComponent_Data_3();

	/***********************************/
	action.setComponent_1(component_1);
	action.setComponent_2_List(component_2_List);
	action.setComponent_3_List(component_3_List);

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
