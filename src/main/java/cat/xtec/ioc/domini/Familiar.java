/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini;


public class Familiar extends Model{
    
    private int numPlaces;
    private int midaMaleter;

    public Familiar(int numPlaces, int midaMaleter, String codi, int any, String model, int preu, String km, String descripcio, int numPressupost) {
        super(codi, any, model, preu, km, descripcio, numPressupost);
        this.numPlaces = numPlaces;
        this.midaMaleter = midaMaleter;
    }    

    public Familiar() {
        super();
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }

    public int getMidaMaleter() {
        return midaMaleter;
    }

    public void setMidaMaleter(int midaMaleter) {
        this.midaMaleter = midaMaleter;
    }
    
}
