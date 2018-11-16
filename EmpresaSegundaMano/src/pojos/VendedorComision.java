package pojos;

import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public class VendedorComision extends Vendedor {

    private double comision;

    public VendedorComision(double comision, String dni, String nombre, String apellido1, String apellido2, String movil, String email, Date fechaAlta) {
        super(dni, nombre, apellido1, apellido2, movil, email, fechaAlta);
        this.comision = comision;
    }

    public VendedorComision() {
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

}
