package extractor_flyweight.model.structure;

import extractor_flyweight.model.data.core.interfaces.IComponent_Data;
import extractor_flyweight.model.structure.core.Component_Structure;

/**
 * @author jvinh
 */
@SuppressWarnings("unused")
public class Component_Structure_1 extends Component_Structure {
    private static final String LOGGER_HEADER = "[" + Component_Structure_1.class.getName() + "] ";
    
    private String codeAction;
    private String codeReference;
    private String dateBegin;
    private String flagEntry;
    private String flagExit;
}
