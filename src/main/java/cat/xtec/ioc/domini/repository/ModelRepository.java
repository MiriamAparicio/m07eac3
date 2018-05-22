package cat.xtec.ioc.domini.repository;
/**
 *
 * @author Miriam
 */
import cat.xtec.ioc.domini.Model;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ModelRepository {
    
    void addModel(Model model);
    Model getModelByCodi(String codi);
    Set<Model> getModelByFilter(Map<String, List<String>> filterParams);

}