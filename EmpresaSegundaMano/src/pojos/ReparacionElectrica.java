package pojos;

import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public class ReparacionElectrica extends Reparacion {

    private String componente;

    public ReparacionElectrica(String componente, Date fecha, String descripcion, Taller taller) {
        super(fecha, descripcion, taller);
        this.componente = componente;
    }

    public ReparacionElectrica() {
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

}
