/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.servei.impl;


import cat.xtec.ioc.domini.Model;
import cat.xtec.ioc.domini.repository.ModelRepository;
import cat.xtec.ioc.servei.PressupostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PressupostServiceImpl implements PressupostService{
    
    @Autowired
    public ModelRepository modelRepository;
    
    public void processPressupostar (String codiModel) {
        
        Model modelByCodi = modelRepository.getModelByCodi(codiModel);
        if (modelByCodi.getNumPressupost() < 5) {
            modelByCodi.setPreu((int) (modelByCodi.getPreu() + (modelByCodi.getPreu()* 0.5)));
        }
    }
}

