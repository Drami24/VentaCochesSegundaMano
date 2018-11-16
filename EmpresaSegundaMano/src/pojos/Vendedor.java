package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public abstract class Vendedor {

    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String movil;
    protected String email;
    protected Date fechaAlta;
    protected Set<Coche> cochesVendidos;

    public Vendedor(String dni, String nombre, String apellido1, String apellido2, String movil, String email, Date fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.movil = movil;
        this.email = email;
        this.fechaAlta = fechaAlta;
        cochesVendidos = new HashSet(0);
    }

    public Vendedor() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(Set<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }

    public void añadirCocheVendido(Coche coche) {
        cochesVendidos.add(coche);
    }

}
