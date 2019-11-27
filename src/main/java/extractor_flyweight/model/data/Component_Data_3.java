package extractor_flyweight.model.data;

import java.util.List;

import extractor_flyweight.model.core.ExtractorModel;
import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.model.structure.Component_Structure_3;
import extractor_flyweight.model.structure.core.Component_StructureFactory;

/**
 * @author jvinh
 */
public class Component_Data_3 extends ExtractorModel implements IComponent_Data {
    private String randomInfo;
    private String randomText;
    private String randomWhatever;
    
    @Override
    public List<String> GetLine() {
	return ((Component_Structure_3) Component_StructureFactory.getComponent_Structure(Component_Structure_3.class))
		    .generateParticle(this, this.isFullDisplayMode());
    }
    
    public String getRandomInfo() {
        return randomInfo;
    }
    public void setRandomInfo(String randomInfo) {
        this.randomInfo = randomInfo;
    }
    public String getRandomText() {
        return randomText;
    }
    public void setRandomText(String randomText) {
        this.randomText = randomText;
    }
    public String getRandomWhatever() {
        return randomWhatever;
    }
    public void setRandomWhatever(String randomWhatever) {
        this.randomWhatever = randomWhatever;
    }
}
