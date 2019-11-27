package extractor_flyweight.model.entity;

import extractor_flyweight.model.action.core.Action_Model;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_3;
import extractor_flyweight.model.data.list.ListComponent_Data_2;

/**
 * Structure of different common components which can be found in Actions
 * Shares the same methods than Action_Model ?
 * 
 * @author jvinh
 */
public class ExtractorEntity extends Action_Model {

    private Component_Data_1 component_1;

    private ListComponent_Data_2 component_2_List;

    private Component_Data_3 component_3;

    public ExtractorEntity() {
	super();
    }

    public ExtractorEntity(Component_Data_1 component_1, ListComponent_Data_2 component_2_List,
		Component_Data_3 component_3) {
	super();
	this.component_1 = component_1;
	this.component_2_List = component_2_List;
	this.component_3 = component_3;
    }

    public Component_Data_1 getComponent_1() {
	return component_1;
    }

    public void setComponent_1(Component_Data_1 component_1) {
	this.component_1 = component_1;
    }

    public ListComponent_Data_2 getComponent_2_List() {
	return component_2_List;
    }

    public void setComponent_2_List(ListComponent_Data_2 component_2_List) {
	this.component_2_List = component_2_List;
    }

    public Component_Data_3 getComponent_3() {
	return component_3;
    }

    public void setComponent_3(Component_Data_3 component_3) {
	this.component_3 = component_3;
    }
}
