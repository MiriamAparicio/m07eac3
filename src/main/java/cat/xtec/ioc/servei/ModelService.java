package cat.xtec.ioc.servei;


import cat.xtec.ioc.domini.Model;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Miriam
 */
public interface ModelService {
    
    void addModel(Model model);
    Model getModelByCodi(String codi);
    Set<Model> getModelByFilter(Map<String, List<String>> filterParams);    
}