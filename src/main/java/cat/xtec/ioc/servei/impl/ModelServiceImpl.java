/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.servei.impl;


import cat.xtec.ioc.domini.Model;
import cat.xtec.ioc.domini.repository.ModelRepository;
import cat.xtec.ioc.servei.ModelService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    
    @Autowired
    private ModelRepository modelRepository;
    
    public void addModel(Model model) {
        modelRepository.addModel(model);
    }
    
    public Model getModelByCodi(String codi) {
        return modelRepository.getModelByCodi(codi);
    }
    
    public Set<Model> getModelByFilter(Map<String, List<String>> filterParams){
        return modelRepository.getModelByFilter(filterParams);
    }
    
    
}
