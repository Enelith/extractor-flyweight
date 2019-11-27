package extractor_flyweight.model.structure.core;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import extractor_flyweight.model.structure.Component_Structure_1;
import extractor_flyweight.model.structure.Component_Structure_2;
import extractor_flyweight.model.structure.Component_Structure_3;
import extractor_flyweight.model.structure.core.interfaces.IComponent_Structure;

/**
 * @author jvinh
 */
public class Component_StructureFactory {
    private static Map<Type, IComponent_Structure> componentCache = new HashMap<Type, IComponent_Structure>();

    private Component_StructureFactory() {

    }

    public static IComponent_Structure getComponent_Structure(Type classType) {
	if (!componentCache.containsKey(classType)) {
	    if (Component_Structure_1.class == classType) {
		componentCache.put(classType, new Component_Structure_1());
	    } else if (Component_Structure_2.class == classType) {
		componentCache.put(classType, new Component_Structure_2());
	    } else if (Component_Structure_3.class == classType) {
		componentCache.put(classType, new Component_Structure_3());
	    }
	}

	return componentCache.get(classType);
    }
}
