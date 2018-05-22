/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini.repository.impl;


import cat.xtec.ioc.domini.Electric;
import cat.xtec.ioc.domini.Familiar;
import cat.xtec.ioc.domini.Model;
import cat.xtec.ioc.domini.Suv;
import cat.xtec.ioc.domini.repository.ModelRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miriam
 */
@Repository
public class InMemoryModelRepository implements ModelRepository {

    private List<Model> catalog = new ArrayList<Model>();

    public InMemoryModelRepository() {

        int codi = 0;

        for (int i = 0; i < 3; i++) {

            Familiar modelFamiliar = new Familiar();
            modelFamiliar.setCodi("F" + codi);
            modelFamiliar.setAny(2011);
            modelFamiliar.setModel("model-F" + codi);
            modelFamiliar.setPreu(40000 + codi);
            modelFamiliar.setKm("100.000km");
            modelFamiliar.setDescripcio("cotxe familiar");
            modelFamiliar.setNumPlaces(6);
            modelFamiliar.setMidaMaleter(25);

            catalog.add(modelFamiliar);

            codi++;

        }

        for (int i = 0; i < 3; i++) {

            Suv modelSuv = new Suv();
            modelSuv.setCodi("S" + codi);
            modelSuv.setAny(2013);
            modelSuv.setModel("model-S" + codi);
            modelSuv.setPreu(40000 + codi);
            modelSuv.setKm("100.000km");
            modelSuv.setDescripcio("cotxe suv");
            modelSuv.setCavalls("90cv");
            modelSuv.setConsum("5l/100km");

            catalog.add(modelSuv);

            codi++;

        }

        for (int i = 0; i < 3; i++) {

            Electric modelElectric = new Electric();
            modelElectric.setCodi("E" + codi);
            modelElectric.setAny(2017);
            modelElectric.setModel("model-E" + codi);
            modelElectric.setPreu(40000 + codi);
            modelElectric.setKm("100.000km");
            modelElectric.setDescripcio("cotxe electric");
            modelElectric.setAutonom(true);
            modelElectric.setKmAutonomia(300);

            catalog.add(modelElectric);

            codi++;

        }

    }

    public void addModel(Model model) {

        catalog.add(model);

    }

    public Model getModelByCodi(String codi) {

        Model modelByCodi = null;

        for (Model model : catalog) {

            if (model != null && model.getCodi() != null && model.getCodi().equals(codi)) {

                modelByCodi = model;
                break;
            }
        }

        if (modelByCodi == null) {

            throw new IllegalArgumentException(
                    "No s'han trobat cotxe amb el codi: " + codi);
        }

        return modelByCodi;

    }

    public Set<Model> getModelByFilter(Map<String, List<String>> filterParams) {
        
        Set<Model> byModel = new HashSet<Model>();
        Set<Model> modelByAny = new HashSet<Model>();
        Set<String> criterias = filterParams.keySet();
        if (criterias.contains("model")) {
            String modelCotxe = filterParams.get("model").get(0);
                for (Model model : catalog) {
                    /*això és una modificació que havia fet per tal que em surtissin els cotxes
                    fent que l'atribut model tingués com a valor el nom del la subclasse*/
                    /*if(model.getModel().equalsIgnoreCase(modelCotxe)) {
                        byModel.add(model);
                    }*/
                    
                    try {
                        if (Class.forName("cat.xtec.ioc.domini." + modelCotxe).isInstance(model)) {
                            byModel.add(model);
                        }
                    } catch (Exception e) {

                    }
                }
            
        }
        if (criterias.contains("any")) {

            String anyCotxe = filterParams.get("any").get(0);
                for (Model model : catalog) {
                    if (Integer.parseInt(anyCotxe) >= model.getAny()) {
                        modelByAny.add(model);
                    }
                }
            
        }
        byModel.retainAll(modelByAny);
        return byModel;
    }
}