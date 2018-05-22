/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini;


/**
 *
 * @author Miriam
 */
public class Electric extends Model {
    
    private boolean autonom;
    private int kmAutonomia;

    public Electric(boolean autonom, int kmAutonomia, String codi, int any, String model, int preu, String km, String descripcio, int numPressupost) {
        super(codi, any, model, preu, km, descripcio, numPressupost);
        this.autonom = autonom;
        this.kmAutonomia = kmAutonomia;
    }

    public Electric() {
        super();
    }
        

    public boolean isAutonom() {
        return autonom;
    }

    public void setAutonom(boolean autonom) {
        this.autonom = autonom;
    }

    public int getKmAutonomia() {
        return kmAutonomia;
    }

    public void setKmAutonomia(int kmAutonomia) {
        this.kmAutonomia = kmAutonomia;
    }
        
}
