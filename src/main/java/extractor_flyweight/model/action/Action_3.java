package extractor_flyweight.model.action;

import extractor_flyweight.model.action.core.Action_Model;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.Component_Data_3;

/**
 * @author jvinh
 */
public class Action_3 extends Action_Model {
    
    private Component_Data_1 component_1;
    
    private Component_Data_3 component_3;

    public Action_3() {
	super();
    }

    public Action_3(Component_Data_1 component_1, Component_Data_3 component_3) {
	super();
	this.component_1 = component_1;
	this.component_3 = component_3;
    }

    public Component_Data_1 getComponent_1() {
        return component_1;
    }

    public void setComponent_1(Component_Data_1 component_1) {
        this.component_1 = component_1;
    }

    public Component_Data_3 getComponent_3() {
        return component_3;
    }

    public void setComponent_3(Component_Data_3 component_3) {
        this.component_3 = component_3;
    }
}
