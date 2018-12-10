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

    public VendedorAsalariado(String text, String text0, String text1, String text2, String text3, String text4, double parseDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
