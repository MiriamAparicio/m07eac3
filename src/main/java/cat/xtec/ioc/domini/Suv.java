/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini;


public class Suv extends Model {
    
    private String cavalls;
    private String consum;

    public Suv(String cavalls, String consum, String codi, int any, String model, int preu, String km, String descripcio, int numPressupost) {
        super(codi, any, model, preu, km, descripcio, numPressupost);
        this.cavalls = cavalls;
        this.consum = consum;
    }

    public Suv() {
        super();
    }
    

    public String getCavalls() {
        return cavalls;
    }

    public void setCavalls(String cavalls) {
        this.cavalls = cavalls;
    }

    public String getConsum() {
        return consum;
    }

    public void setConsum(String consum) {
        this.consum = consum;
    }    
    
}
