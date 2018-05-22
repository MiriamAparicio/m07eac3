/**
 *
 * @author Miriam
 */

package cat.xtec.ioc.domini;


public class Options {

    private String title;
    private String descripcio;
    private String url;
    private String icon;

    public Options(String title, String descripcio, String url, String icon) {
        
        this.title = title;
        this.descripcio = descripcio;
        this.url = url;
        this.icon = icon;

    }
    
    public Options () {
        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    

}
