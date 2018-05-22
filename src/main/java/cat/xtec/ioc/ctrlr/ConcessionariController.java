/**
 *
 * @author Miriam
 */
package cat.xtec.ioc.ctrlr;

import cat.xtec.ioc.domini.Familiar;
import cat.xtec.ioc.domini.Model;
import cat.xtec.ioc.servei.ModelService;
import cat.xtec.ioc.servei.OptionsService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConcessionariController {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homeRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("home");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "");
        modelView.getModelMap().addAttribute("options", optionsService.getOptionsInici());
        return modelView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addModelRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("home");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "");
        modelView.getModelMap().addAttribute("options", optionsService.getOptionsAdd());
        return modelView;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getModelFormRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("getModelForm");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        return modelView;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ModelAndView getModelByCodiRequest(@RequestParam("codi") String codi, HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String codiModel = (String) request.getParameter("codi");
        ModelAndView modelView = new ModelAndView("infoModel");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Dades d'un model de cotxe");
        modelView.getModelMap().addAttribute("r", modelService.getModelByCodi(codiModel));
        return modelView;

    }

    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ModelAndView getModelByFilter(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("helpFilter");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Ajuda per la creació d'un filtre");
        return modelView;
    }

    @RequestMapping(value = "/filter/{ByCriteria}", method = RequestMethod.GET)
    public ModelAndView getModelByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("listModelByFilter");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Llistat de Models de cotxe que compleixen els requisits");
        modelView.getModelMap().addAttribute("model", modelService.getModelByFilter(filterParams));
        return modelView;
    }

    @RequestMapping(value = "/budget", method = RequestMethod.GET)
    public ModelAndView getPressupost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("helpPressupost");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Ajuda per la creació d'un pressupost");
        return modelView;
    }

    @RequestMapping(value = "/getModel/{codi}", method = RequestMethod.GET)
    public ModelAndView getModelByCodiPressupostRequest(@PathVariable("codi") String codi, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("infoModel");
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Dades d'un model de cotxe");
        modelView.getModelMap().addAttribute("r", modelService.getModelByCodi(codi));
        return modelView;
    }

    @RequestMapping(value = "/add/{tipus}", method = RequestMethod.GET)
    public ModelAndView addModelForm(@PathVariable("tipus") String tipus, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("add" + tipus);
        modelView.getModelMap().addAttribute("banner", "Programa de Gestió del Concessionari!");
        modelView.getModelMap().addAttribute("tagline", "Afegir un model de tipus " + tipus);
        try {

            modelView.getModelMap().addAttribute("newModel", Class.forName("cat.xtec.ioc.domini." + tipus).newInstance());

        } catch (Exception e) {

        }
        return modelView;
    }

    @RequestMapping(value = "/add/{tipus}", method = RequestMethod.POST)
    public String addModelForm(@PathVariable("tipus") String tipus, @ModelAttribute("newModel") Model newModelToAdd,
            BindingResult result) {
        /*el Model passat per parametre ha perdut la identitat i no es compleix el instanceof
        per lo que alhora de fer un filtre per classe no apareixerà
        si que d'afegeix al cataleg i es pot cercar per codi i fer un pressupost
        */
        /*if (newModelToAdd instanceof Familiar) {
            System.out.println("FAMILIAR");
        }*/

        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        modelService.addModel(newModelToAdd);

        return "redirect:/";
    }

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setDisallowedFields("numPressupost");
    }

}
