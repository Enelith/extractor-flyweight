package extractor_flyweight.model.action;

import extractor_flyweight.model.action.core.Action_Model;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_2;
import extractor_flyweight.model.data.list.ListComponent_Data_3;

/**
 * @author jvinh
 */
public class Action_2 extends Action_Model {
    
    private Component_Data_1 component_1;
    
    private Component_Data_2 component_2;
    
    private ListComponent_Data_3 component_3_List;

    public Action_2() {
	super();
    }

    public Action_2(Component_Data_1 component_1, Component_Data_2 component_2, ListComponent_Data_3 component_3_List) {
	super();
	this.component_1 = component_1;
	this.component_2 = component_2;
	this.component_3_List = component_3_List;
    }

    public Component_Data_1 getComponent_1() {
        return component_1;
    }

    public void setComponent_1(Component_Data_1 component_1) {
        this.component_1 = component_1;
    }

    public Component_Data_2 getComponent_2() {
        return component_2;
    }

    public void setComponent_2(Component_Data_2 component_2) {
        this.component_2 = component_2;
    }

    public ListComponent_Data_3 getComponent_3_List() {
        return component_3_List;
    }

    public void setComponent_3_List(ListComponent_Data_3 component_3_List) {
        this.component_3_List = component_3_List;
    }
}
