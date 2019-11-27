package extractor_flyweight.model.structure.core.interfaces;

import java.util.List;

import extractor_flyweight.model.data.core.interfaces.IComponent_Data;

/**
 * @author jvinh
 */
public interface IComponent_Structure {
    List<String> generateParticle(IComponent_Data data, boolean isFullDisplay);
}
