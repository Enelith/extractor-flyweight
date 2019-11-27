package extractor_flyweight.model.action;

import extractor_flyweight.model.action.core.Action_Model;
import extractor_flyweight.model.data.Component_Data_1;
import extractor_flyweight.model.data.list.ListComponent_Data_2;
import extractor_flyweight.model.entity.ExtractorEntity;
import extractor_flyweight.model.entity.ListExtractorEntity;

/**
 * @author jvinh
 */
public class Action_4 extends Action_Model {
    
    private Component_Data_1 component_1;
    
    private ListComponent_Data_2 component_2_List;
    
    private ExtractorEntity extractorEntity;
    
    private ListExtractorEntity extractorEntityList;

    public Action_4() {
	super();
    }

    public Action_4(Component_Data_1 component_1, ListComponent_Data_2 component_2_List,
		ExtractorEntity extractorEntity, ListExtractorEntity extractorEntityList) {
	super();
	this.component_1 = component_1;
	this.component_2_List = component_2_List;
	this.extractorEntity = extractorEntity;
	this.extractorEntityList = extractorEntityList;
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

    public ExtractorEntity getExtractorEntity() {
        return extractorEntity;
    }

    public void setExtractorEntity(ExtractorEntity extractorEntity) {
        this.extractorEntity = extractorEntity;
    }

    public ListExtractorEntity getExtractorEntityList() {
        return extractorEntityList;
    }

    public void setExtractorEntityList(ListExtractorEntity extractorEntityList) {
        this.extractorEntityList = extractorEntityList;
    }
}
