package extractor_flyweight.test;

import java.util.Date;
import java.util.List;

import extractor_flyweight.exception.ValidationErrorException;
import extractor_flyweight.model.action.Action_4;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_2;
import extractor_flyweight.model.data.Component_Data_3;
import extractor_flyweight.model.data.list.ListComponent_Data_2;
import extractor_flyweight.model.entity.ExtractorEntity;
import extractor_flyweight.model.entity.ListExtractorEntity;
import extractor_flyweight.utils.ExtractorUtils;

/**
 * @author jvinh
 */
public class Action_4_Test {

    public static void main(String[] args) {

	boolean fullDisplayMode = true;

	Action_4 action = new Action_4();
	action.setFullDisplayMode(fullDisplayMode);

	/***********************************/
	Component_Data_1 component_1 = new Component_Data_1();
	component_1.setFullDisplayMode(action.isFullDisplayMode());
	component_1.setCodeAction(action.getCodeAction());
	component_1.setCodeReference(action.getCodeReference());
	component_1.setDateBegin(ExtractorUtils.dateConvertor(new Date()));

	/***********************************/
	ListComponent_Data_2 component_2_0_List = new ListComponent_Data_2();
	Component_Data_2 component_2_0 = new Component_Data_2();
	component_2_0.setFullDisplayMode(action.isFullDisplayMode());
	component_2_0.setLastname("DIRTY");
	component_2_0.setFirstname("Harry");
	component_2_0.setCity("San Francisco");
	component_2_0_List.add(component_2_0);

	Component_Data_2 component_2_1 = new Component_Data_2();
	component_2_1.setFullDisplayMode(action.isFullDisplayMode());
	component_2_1.setLastname("WAYNE");
	component_2_1.setFirstname("Bruce");
	component_2_1.setCity("Gotham");
	component_2_0_List.add(component_2_1);

	/***********************************/
	ExtractorEntity extractorEntity_0 = new ExtractorEntity();
	extractorEntity_0.setFullDisplayMode(action.isFullDisplayMode());
	extractorEntity_0.setComponent_1(component_1);

	ListComponent_Data_2 component_2_1_List = new ListComponent_Data_2();
	Component_Data_2 component_2_2 = new Component_Data_2();
	component_2_2.setFullDisplayMode(action.isFullDisplayMode());
	component_2_2.setLastname("BOURNE");
	component_2_2.setFirstname("Jason");
	component_2_2.setCity("Undefined");
	component_2_1_List.add(component_2_2);

	Component_Data_2 component_2_3 = new Component_Data_2();
	component_2_3.setFullDisplayMode(action.isFullDisplayMode());
	component_2_3.setLastname("BAUER");
	component_2_3.setFirstname("Jack");
	component_2_3.setCity("Los Angeles");
	component_2_1_List.add(component_2_3);

	extractorEntity_0.setComponent_2_List(component_2_1_List);

	Component_Data_3 component_3 = new Component_Data_3();
	component_3.setFullDisplayMode(action.isFullDisplayMode());
	component_3.setRandomInfo("Random Info 2");
	component_3.setRandomText("Random Text associed");
	component_3.setRandomWhatever("Things to do");
	extractorEntity_0.setComponent_3(component_3);

	/***********************************/
	ListExtractorEntity extractorEntityList = new ListExtractorEntity();

	ExtractorEntity extractorEntity_1 = new ExtractorEntity();
	extractorEntity_1.setFullDisplayMode(action.isFullDisplayMode());
	extractorEntity_1.setComponent_1(component_1);

	ListComponent_Data_2 component_2_2_List = new ListComponent_Data_2();
	Component_Data_2 component_2_4 = new Component_Data_2();
	component_2_4.setFullDisplayMode(action.isFullDisplayMode());
	component_2_4.setLastname("BANNER");
	component_2_4.setFirstname("Bruce");
	component_2_4.setCity("Undefined");
	component_2_2_List.add(component_2_4);
	extractorEntity_1.setComponent_2_List(component_2_2_List);

	component_3 = new Component_Data_3();
	component_3.setFullDisplayMode(action.isFullDisplayMode());
	component_3.setRandomInfo("Random Info 10");
	component_3.setRandomText("Random Text associed 10");
	component_3.setRandomWhatever("Things to do 10");
	extractorEntity_1.setComponent_3(component_3);

	extractorEntityList.add(extractorEntity_1);

	ExtractorEntity extractorEntity_2 = new ExtractorEntity();
	extractorEntity_2.setFullDisplayMode(action.isFullDisplayMode());
	extractorEntity_2.setComponent_1(component_1);

	ListComponent_Data_2 component_2_3_List = new ListComponent_Data_2();
	Component_Data_2 component_2_5 = new Component_Data_2();
	component_2_5.setFullDisplayMode(action.isFullDisplayMode());
	component_2_5.setLastname("STARK");
	component_2_5.setFirstname("Tony");
	component_2_5.setCity("Undefined");
	component_2_3_List.add(component_2_5);
	extractorEntity_2.setComponent_2_List(component_2_3_List);

	component_3 = new Component_Data_3();
	component_3.setFullDisplayMode(action.isFullDisplayMode());
	component_3.setRandomInfo("Random Info 20");
	component_3.setRandomText("Random Text associed 20");
	component_3.setRandomWhatever("Things to do 20");
	extractorEntity_2.setComponent_3(component_3);

	extractorEntityList.add(extractorEntity_2);

	/***********************************/
	action.setComponent_1(component_1);
	action.setComponent_2_List(component_2_0_List);
	action.setExtractorEntity(extractorEntity_0);
	action.setExtractorEntityList(extractorEntityList);

	try {
	    action.validate();

	    System.out.println("RESULT IF VALIDATE CORRECT");
	    List<String> result = action.generationAction();
	    result.stream().forEach(a -> {
		System.out.println(a);
	    });
	} catch (ValidationErrorException e) {
	    System.out.println("ERROR : " + e.getMessage());
	}

	System.out.println("RESULT NO MATTER");
	List<String> result = action.generationAction();
	result.stream().forEach(a -> {
	    System.out.println(a);
	});
    }
}
