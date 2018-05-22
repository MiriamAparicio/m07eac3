/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini.repository;

import cat.xtec.ioc.domini.Options;
import java.util.List;


public interface OptionsRepository {
    
    List<Options> getOptionsInici();   
    List<Options> getOptionsAdd();
    
}