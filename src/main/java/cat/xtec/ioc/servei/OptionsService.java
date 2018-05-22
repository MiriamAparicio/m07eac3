package cat.xtec.ioc.servei;

import cat.xtec.ioc.domini.Options;
import java.util.List;

/**
 *
 * @author Miriam
 */
public interface OptionsService {
    
    List<Options> getOptionsInici();
    List<Options> getOptionsAdd();
}