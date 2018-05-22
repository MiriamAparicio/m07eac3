/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini;

public class Model {
    
    private String codi;
    private int any;
    private String model;
    private int preu;
    private String km;
    private String descripcio;
    private int numPressupost;
    

    public Model(String codi, int any, String model, int preu, String km, String descripcio, int numPressupost) {
        this.codi = codi;
        this.any = any;
        this.model = model;
        this.preu = preu;
        this.km = km;
        this.descripcio = descripcio;
        this.numPressupost = numPressupost;
    }

    public Model() {
    }    

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getNumPressupost() {
        return numPressupost;
    }

    public void setNumPressupost(int numPressupost) {
        this.numPressupost = numPressupost;
    }
    
    
}
