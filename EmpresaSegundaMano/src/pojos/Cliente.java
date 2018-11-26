package pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a16jorgemf
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String movil;
    private String email;
    private Date fechaAlta;
    private Set<Coche> cochesComprados;
    private Set<Coche> cochesReservados;

    public Cliente(String dni, String nombre, String apellido1, String apellido2, String movil, String email, Date fechaAlta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.movil = movil;
        this.email = email;
        this.fechaAlta = fechaAlta;
        cochesComprados = new HashSet(0);
        cochesReservados = new HashSet(0);
    }

    public Cliente() {
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

    public Set<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(Set<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public Set<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(Set<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }

    public void añadirCocheComprado(Coche coche) {
        cochesComprados.add(coche);
    }

    public void añadirCocheReservado(Coche coche) {
        cochesReservados.add(coche);
    }

}
