package extractor_flyweight.model.data;

import java.util.List;

import extractor_flyweight.model.core.ExtractorModel;
import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.model.structure.Component_Structure_1;
import extractor_flyweight.model.structure.core.Component_StructureFactory;

/**
 * @author jvinh
 */
public class Component_Data_1 extends ExtractorModel implements IComponent_Data {
    private String codeAction;
    private String codeReference;
    private String dateBegin;
    private String flagEntry;
    private String flagExit;

    @Override
    public List<String> GetLine() {
	return ((Component_Structure_1) Component_StructureFactory.getComponent_Structure(Component_Structure_1.class))
		    .generateParticle(this, this.isFullDisplayMode());
    }

    public String getCodeAction() {
	return codeAction;
    }

    public void setCodeAction(String codeAction) {
	this.codeAction = codeAction;
    }

    public String getCodeReference() {
	return codeReference;
    }

    public void setCodeReference(String codeReference) {
	this.codeReference = codeReference;
    }

    public String getDateBegin() {
	return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
	this.dateBegin = dateBegin;
    }

    public String getFlagEntry() {
	return flagEntry;
    }

    public void setFlagEntry(String flagEntry) {
	this.flagEntry = flagEntry;
    }

    public String getFlagExit() {
	return flagExit;
    }

    public void setFlagExit(String flagExit) {
	this.flagExit = flagExit;
    }
}
