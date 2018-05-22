/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.ctrlr;


import cat.xtec.ioc.servei.PressupostService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PressupostController {
    
    @Autowired
    private PressupostService pressupostService;
    
    @RequestMapping (value = "/pressupostModel/{codi}", method = RequestMethod.GET)
    public String pressupostar(@PathVariable("codi") String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pressupostService.processPressupostar(codi);
        return "redirect:/getModel/" + codi;
    }

}
