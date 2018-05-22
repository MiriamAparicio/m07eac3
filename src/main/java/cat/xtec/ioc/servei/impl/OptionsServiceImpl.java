/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.servei.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cat.xtec.ioc.domini.Options;
import cat.xtec.ioc.domini.repository.OptionsRepository;
import cat.xtec.ioc.servei.OptionsService;
import java.util.List;


@Service
public class OptionsServiceImpl implements OptionsService {
    
    @Autowired
    private OptionsRepository optionsRepository;
    
    public List<Options> getOptionsInici() {
        return optionsRepository.getOptionsInici();
    }
    public List<Options> getOptionsAdd() {
        
        return optionsRepository.getOptionsAdd();
    }
}
