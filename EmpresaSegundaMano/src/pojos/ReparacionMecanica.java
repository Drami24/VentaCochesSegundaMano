package pojos;

import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public class ReparacionMecanica extends Reparacion {

    private String parte;

    public ReparacionMecanica(String parte, Date fecha, String descripcion, Taller taller) {
        super(fecha, descripcion, taller);
        this.parte = parte;
    }

    public ReparacionMecanica() {

    }

    public String getParte() {
        return parte;
    }

    public void setParte(String parte) {
        this.parte = parte;
    }

}
