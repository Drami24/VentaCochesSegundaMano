package pojos;

import java.util.Date;

/**
 *
 * @author a16jorgemf
 */
public class VendedorAsalariado extends Vendedor {

    private double salario;

    public VendedorAsalariado(double salario, String dni, String nombre, String apellido1, String apellido2, String movil, String email, Date fechaAlta) {
        super(dni, nombre, apellido1, apellido2, movil, email, fechaAlta);
        this.salario = salario;
    }

    public VendedorAsalariado() {

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
