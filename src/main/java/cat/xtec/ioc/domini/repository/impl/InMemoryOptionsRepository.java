/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini.repository.impl;


import cat.xtec.ioc.domini.Options;
import cat.xtec.ioc.domini.repository.OptionsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryOptionsRepository implements OptionsRepository {
    
    private List<Options> optionsInici = new ArrayList<Options>();
    private List<Options> optionsAdd = new ArrayList<Options>();
    
    public InMemoryOptionsRepository() {
        
        Options afegir = new Options();
        afegir.setTitle("Afegir");
        afegir.setDescripcio("Permet afegir un nou model de cotxe al concessionari");
        afegir.setUrl("/add");
        afegir.setIcon("glyphicon-road glyphicon");
        
        Options consultar = new Options();
        consultar.setTitle("Consultar");
        consultar.setDescripcio("Permet consultar la informarció d'un model de cotxe del concessionari");
        consultar.setUrl("/get");
        consultar.setIcon("glyphicon-road glyphicon");
        
        Options filtre = new Options();
        filtre.setTitle("Filtrar");
        filtre.setDescripcio("Permet cercar, dins del catàleg concessionari, alguns models");
        filtre.setUrl("/filter");
        filtre.setIcon("glyphicon-road glyphicon");
        
        Options budget = new Options();
        budget.setTitle("Pressupost");
        budget.setDescripcio("Permet demanar un pressupost d'algun model de cotxe del concessionari");
        budget.setUrl("/budget");
        budget.setIcon("glyphicon-road glyphicon");
        
        optionsInici.add(afegir);
        optionsInici.add(consultar);
        optionsInici.add(filtre);
        optionsInici.add(budget);

        Options opcioAddFamiliar = new Options();
        opcioAddFamiliar.setTitle("Familiar");
        opcioAddFamiliar.setDescripcio("Permet afegir un cotxe de tipus familiar al concessionari");
        opcioAddFamiliar.setUrl("/add/Familiar");
        opcioAddFamiliar.setIcon("glyphicon-tent glyphicon");
        
        Options opcioAddSuv = new Options();
        opcioAddSuv.setTitle("SUV");
        opcioAddSuv.setDescripcio("Permet afegir un cotxe de tipus suv al concessionari");
        opcioAddSuv.setUrl("/add/Suv");
        opcioAddSuv.setIcon("glyphicon-tent glyphicon");
        
        Options opcioAddElectric = new Options();
        opcioAddElectric.setTitle("Electric");
        opcioAddElectric.setDescripcio("Permet afegir un cotxe de tipus electric al concessionari");
        opcioAddElectric.setUrl("/add/Electric");
        opcioAddElectric.setIcon("glyphicon-tent glyphicon");
        
        optionsAdd.add(opcioAddFamiliar);
        optionsAdd.add(opcioAddSuv);
        optionsAdd.add(opcioAddElectric);
    }
    
    public List<Options> getOptionsInici(){
        
        return optionsInici;
    }
    
    public List<Options> getOptionsAdd() {
        
        return optionsAdd;
    }

}
